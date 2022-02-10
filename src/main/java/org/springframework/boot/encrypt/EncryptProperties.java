package org.springframework.boot.encrypt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.encrypt" )
@Data
public class EncryptProperties {

    private String key;

}
