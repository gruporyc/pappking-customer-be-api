package co.ppk.service.impl;

import co.ppk.domain.Customer;
import co.ppk.dto.CustomerDto;
import co.ppk.service.BusinessManager;
import co.ppk.utilities.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BussinessManagerImpl implements BusinessManager{

    private static CustomerRepository customerRepository;

    public BussinessManagerImpl() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public Customer getCustomer(String customerId) {
        if(customerRepository.getCustomer(customerId).isPresent()){
            return customerRepository.getCustomer(customerId).get();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    public String createCustomer(CustomerDto customer) {
        if(customerRepository.getCustomerByIdentification(customer.getIdentification()).isPresent()) {
            return "";
        }
        return customerRepository.createCustomer(customer);
    }
}
