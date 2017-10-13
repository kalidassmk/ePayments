package com.epayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The type E payments application.
 */
@SpringBootApplication
@EnableAsync
public class EPaymentsApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(EPaymentsApplication.class, args);
	}

}
