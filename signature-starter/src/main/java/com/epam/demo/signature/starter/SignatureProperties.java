package com.epam.demo.signature.starter;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Duration;

@Validated
@ConfigurationProperties("demo.signature")
public class SignatureProperties {
    //Для того чтобы в application.properties появлялись подсказки нужно
    //подключить зависимость и над полем писать javadoc
    /**
     * Username for email signature
     */
    @NotBlank
    @Size(min = 5, max = 100)
    private String username = "NONAME";
    private Extra extra = new Extra();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    /**
     * Retention period for email
     */
    public static class Extra {
        @DurationMin(minutes = 5)
        @DurationMax(hours = 1)
        private Duration retentionPeriod = Duration.ofMinutes(5);

        public Duration getRetentionPeriod() {
            return retentionPeriod;
        }

        public void setRetentionPeriod(Duration retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }
}
