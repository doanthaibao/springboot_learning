package bao.doan.learning.config;

import bao.doan.learning.model.AcmeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AcmeProperties.class)
public class AcmeConfiguration {

}
