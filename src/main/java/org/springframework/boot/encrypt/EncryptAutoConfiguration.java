package org.springframework.boot.encrypt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EncryptProperties.class)
public class EncryptAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(DecryptRequestBodyAdvice.class)
    DecryptRequestBodyAdvice decryptRequestBodyAdvice(){
        return new DecryptRequestBodyAdvice();
    };

}
