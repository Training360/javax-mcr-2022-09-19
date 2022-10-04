package training.employees.employees.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "gateway")
public class GatewayProperties {

    private String url;

    private String timeout = "PT5S";

    private int threads = 5;
}
