import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class GCConfiguration extends Configuration
{
  @NotEmpty
  @JsonProperty
  public String gcEvent;
  public String gcEventDefault = "";

  public String getGcEvent() {
    return gcEvent;
  }

  public String getGcEventDefault() {
    return gcEventDefault;
  }
}
