import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class GCService extends Service<GCConfiguration>
{
  public static void main(String[] args) throws Exception {
    new GCService().run(args);
  }

  @Override
  public void initialize(Bootstrap<GCConfiguration> bootstrap) {
    //TODO fill in the method to initialize the program
  }

  @Override
  public void run(GCConfiguration configuration, Environment environment) {
    //TODO generate listener for program as well as the ReactJS program
  }
}
