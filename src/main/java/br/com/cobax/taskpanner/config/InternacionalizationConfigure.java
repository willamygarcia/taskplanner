package br.com.cobax.taskpanner.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizationConfigure {

    @Bean
    MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.addBasenames("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setDefaultLocale(Locale.getDefault());
		return messageSource;
	}
	@Bean
	LocalValidatorFactoryBean localValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(this.messageSource());
		return bean;
	}

}
