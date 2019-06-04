/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/
package co.ppk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Configuration class for Spring IOC
 *
 * @author jmunoz
 * 
 * @version 1.0
 */

@SpringBootApplication
public class CustomerAPIApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CustomerAPIApplication.class, args);
	}

}
