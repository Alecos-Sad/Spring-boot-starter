package com.epam.demo.signature.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.epam.demo.signature.starter")
@ConditionalOnProperty(value = "demo.signature.enabled", havingValue = "true", matchIfMissing = true)
public class SignatureAutoConfiguration {
}
