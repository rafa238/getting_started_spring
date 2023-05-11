package com.rafa238.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:text.properties")
	//we can set more properties files
})
public class TextPropertiesConfig {

}
