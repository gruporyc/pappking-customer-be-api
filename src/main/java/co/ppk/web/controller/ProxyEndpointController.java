/******************************************************************
 *  
 * This code is for the Pappking service project.
 *
 * 
 * © 2018, Pappking Management All rights reserved.
 * 
 * 
 ******************************************************************/

package co.ppk.web.controller;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import co.ppk.domain.Customer;
import co.ppk.dto.CustomerDto;
import co.ppk.service.BusinessManager;
import co.ppk.utilities.CustomerRepository;
import co.ppk.utilities.DataSourceSingleton;
import co.ppk.validators.CustomerValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.ppk.enums.ResponseKeyName;

/**
 * Only service exposition point of services to FE layer
 * 
 * @author jmunoz
 *
 */

@RestController
@RequestMapping("/v1")
public class ProxyEndpointController extends BaseRestController {

	private static final Logger LOGGER = LogManager.getLogger(ProxyEndpointController.class);

	private static final String CURRENT_USER_LOCALE = "language";

	/** The error properties. */
	@Autowired
	@Qualifier("errorProperties")
	private Properties errorProperties;

	@Autowired
	BusinessManager businessManager;

	@Autowired
    CustomerValidator customerValidator;

	/**
	 * entry endpoint receiving the message from messaging API to perform proper action
	 *
	 * @since 30/06/2018
	 *
	 * @author jmunoz
	 * @version 1.0
	 */

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomers() {
        List<Customer> customers = businessManager.getCustomers();

        if(customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.customer, customers));

    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@Validated @RequestBody CustomerDto customer,
                                                 BindingResult result) {
        customerValidator.validate(customer, result);
        ResponseEntity<Object> responseEntity = apiValidator(result);
        if (responseEntity != null) {
            return responseEntity;
        }

        String customerId = businessManager.createCustomer(customer);
        if(customerId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.customerId, customerId));
    }

	@RequestMapping(value = "/customer/{customer_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCustomer(@PathVariable("customer_id") String customerId) {
		Customer customer = businessManager.getCustomer(customerId);

		if(Objects.isNull(customer)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(createSuccessResponse(ResponseKeyName.customer, customer));

	}
}
