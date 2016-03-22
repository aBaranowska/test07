package com.rec.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = { "theExampleService", "exampleServiceAlias" })
	public Service exampleServiceBean() {
		return new ExampleService();
	}

}
