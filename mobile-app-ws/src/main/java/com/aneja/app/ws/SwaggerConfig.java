package com.aneja.app.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	Contact contact = new Contact(
			"Navneet Behl",
			"http://WebSiteStillInProduction.com",
			"behl_navneet@yahoo.com"
			);
	/**
	 * Vendor extensions are custom properties (e.g. x-logger etc. which can be used to describe
	 * extra functionality not covered by open API specifications.
	 */
	List<VendorExtension> vendorExtensions = new ArrayList<>();
	
	
	ApiInfo apiInfo = new ApiInfo(
			"Photo app RESTful Web Service documentation",
			"This pages documents Photo app RESTful Web Service endpoints",
			"1.0",
			"http://www.WebSiteStillInProduction.com/service.html",
			contact,
			"Apache 2.0",
			"http://www.apache.org/license/LICENSE-2.0",
			vendorExtensions);
	
	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.protocols(new HashSet<>(Arrays.asList("HTTP", "HTTPs")))
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.behl.app.ws"))
				.paths(PathSelectors.any())
				.build();
		
		return docket;
	}

}
