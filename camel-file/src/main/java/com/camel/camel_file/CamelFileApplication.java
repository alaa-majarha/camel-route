package com.camel.camel_file;

import com.camel.camel_file.routes.File;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelFileApplication.class, args);

		try(CamelContext context = new DefaultCamelContext()) {
			// Create a new Camel context


			// Add the route to the context
			context.addRoutes(new File());

			// Start the context
			context.start();

			// Keep the application running for 5 minutes
			Thread.sleep(2000);

			// Stop the context
			context.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}