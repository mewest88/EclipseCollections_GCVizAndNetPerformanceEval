import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;
import java.util.Map;


public class UserProgram implements UserProgramMBean
{
  private long id1;
  private long id2;
  //username and password to be used if the connection is remote, local is optional for these values
  private String userName;
  private String password;

  @Override
  public String getUserInfo() {
    System.out.println("This is the username: " + userName);
    return userName;
  }
  @Override
  public void setUserInfo(String _userName) {
    userName = _userName;
  }
  //don't allow them to set the user id. This should be found by grabbing the info from the connection
  @Override
  public void getGCInstance() {

  }
}
