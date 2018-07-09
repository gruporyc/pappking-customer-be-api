package co.ppk.service;

import co.ppk.domain.Customer;
import co.ppk.dto.CustomerDto;

import java.util.List;

public interface BusinessManager {
    Customer getCustomer(String customerId);

    List<Customer> getCustomers();

    String createCustomer(CustomerDto customer);
}
