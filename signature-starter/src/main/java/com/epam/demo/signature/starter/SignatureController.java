package com.epam.demo.signature.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;


@RestController
public class SignatureController {
    private final Logger LOG = LoggerFactory.getLogger(SignatureController.class);
    private final String username;
    private final Duration retentionPeriod;

    public SignatureController(SignatureProperties properties) {
        this.username = properties.getUsername();
        this.retentionPeriod = properties.getExtra().getRetentionPeriod();
        LOG.info("Using following configuration: 'username' - {}, 'retention period' - {}", username, retentionPeriod);
    }

    @GetMapping("/api/v1/signature")
    public String getSignature() {
        return "Best regards\n" + username + "\n\nEmail will be deleted after: " + retentionPeriod;
    }
}
