package com.epam.demo.signature.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.epam.demo.signature.starter")
@EnableConfigurationProperties(SignatureProperties.class)
//Чтобы было подсказка в application.properties на эту проперти - написан additional-spring-configuration-metadata.json
@ConditionalOnProperty(value = "demo.signature.enabled", havingValue = "true", matchIfMissing = true)
public class SignatureAutoConfiguration {
}
