package com.epam.demo.signature.starter;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class SignatureAutoConfigurationIT {

    @Test
        //позитивный тест
    void shouldAutoConfigurationBeAppliedToWebApplication() {
        new WebApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(SignatureAutoConfiguration.class))
                //запускаем контекст и проверяем условия
                .run(context -> {
                    assertThat(context)
                            .hasNotFailed()
                            .hasSingleBean(SignatureController.class)
                            .hasSingleBean(SignatureProperties.class)
                            .getBean(SignatureProperties.class)
                            .hasNoNullFieldsOrProperties();
                });
    }

    @Test
        //негативный тест
    void shouldAutoConfigurationBeFailedToValidateConstraints() {
        new WebApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(SignatureAutoConfiguration.class))
                .withPropertyValues(
                        "demo.signature.username=Uma"
                )
                .run(context -> {
                    assertThat(context)
                            .hasFailed()
                            .getFailure()
                            .hasRootCauseInstanceOf(BindValidationException.class)
                            .hasStackTraceContaining("'demo.signature' on field 'username'");
                });
    }
}
