import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/main/java")
@Produces(MediaType.APPLICATION_JSON)
public class GCResource
{
  @GET
  @Timed
  public void GarbageCollection() {

  }
}
