import javax.management.*;

import com.sun.management.GarbageCollectorMXBean;
import com.sun.management.GcInfo;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.MemoryUsage;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class GCInformationWithJMX {
    public void monitor(int vmpid) throws Exception {
        JMXServiceURL url = new JMXServiceURL(getVMAddress(vmpid));
        JMXConnector connector = JMXConnectorFactory.connect(url);

        final MBeanServerConnection serverConnection = connector.getMBeanServerConnection();
        Set<ObjectName> beanSet = serverConnection.queryNames(new ObjectName("java.lang:type=GarbageCollector,name=PS MarkSweep"), null);

        final ObjectName bean = beanSet.iterator().next();

        GarbageCollectorMXBean gcBean = JMX.newMXBeanProxy(serverConnection,bean, GarbageCollectorMXBean.class);
        System.out.println("collection time: " + gcBean.getCollectionTime());
        System.out.println("collection count: " + gcBean.getCollectionCount());

        GcInfo gcInfo = gcBean.getLastGcInfo();
        Map<String, MemoryUsage> memUsages = gcInfo.getMemoryUsageBeforeGc();
        for (Map.Entry<String, MemoryUsage> memUsage : memUsages.entrySet()) {
            System.out.println(memUsage.getKey() + ": " + memUsage.getValue());
        }

        listenToNotifications(serverConnection, bean);
    }

    private String getVMAddress(int pid) throws AttachNotSupportedException, IOException {
        String jmxAddressProp = "com.sun.management.jmxremote.localConnectorAddress";
        VirtualMachine vm = VirtualMachine.attach(String.valueOf(pid));
        return vm.getAgentProperties().getProperty(jmxAddressProp);
    }

    private void listenToNotifications(final MBeanServerConnection serverConnection, final ObjectName bean) throws InstanceNotFoundException, IOException {
        final Queue<Notification> notifications = new LinkedBlockingQueue<Notification>();
        NotificationListener listener = new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object ctx) {
                notifications.add(notification);
            }
        };
        serverConnection.addNotificationListener(bean, listener, null, null);

        while (true) {
            Notification notification = notifications.poll();
            if (notification != null) {
                process(notification);
            }
        }
    }

    private void process(Notification notification) {
        System.out.println("In Notification Method");
        String messageOut = notification.getMessage();
        long seqNum = notification.getSequenceNumber();
        long timeStamp = notification.getTimeStamp();
        String type = notification.getType();
        Object userData = notification.getUserData();
        System.out.println("Sequence Number: " + seqNum + " | TimeStamp: " + timeStamp + " | Type: " + type + " | Message Out: " + messageOut);

    }
}
