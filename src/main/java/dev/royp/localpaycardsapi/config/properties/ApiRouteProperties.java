package dev.royp.localpaycardsapi.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration("ApiRouteProperties")
@ConfigurationProperties(prefix = "api.routes")
public class ApiRouteProperties {

  private String creditCardsUri;

  private String creditCardsIdUri;
}
