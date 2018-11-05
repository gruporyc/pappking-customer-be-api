package co.ppk.service.impl;

import co.ppk.data.FaceplateRepository;
import co.ppk.domain.Customer;
import co.ppk.domain.Faceplate;
import co.ppk.dto.CustomerDto;
import co.ppk.dto.FaceplateDto;
import co.ppk.service.BusinessManager;
import co.ppk.data.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class BussinessManagerImpl implements BusinessManager{

    private static FaceplateRepository faceplateRepository;
    private static CustomerRepository customerRepository;


    public BussinessManagerImpl() {
        customerRepository = new CustomerRepository();
        faceplateRepository = new FaceplateRepository();
    }


    @Override
    public CustomerDto getCustomerByIdentification(String identification) {
        Optional<Customer> customer = customerRepository.getCustomerByIdentification(identification);
        CustomerDto response = new CustomerDto();
        if (!customer.isPresent()) {
            return response;
        }
        response.setId(customer.get().getId());
        response.setIdentification(customer.get().getIdentification());
        response.setName(customer.get().getName());
        response.setLastName(customer.get().getLastName());
        response.setEmail(customer.get().getEmail());
        response.setAddress(customer.get().getAddress());
        response.setPhone(customer.get().getPhone());
        response.setStatus(customer.get().getStatus());
        return response;
    }


    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    public String createCustomer(CustomerDto customer) {
        if(customerRepository.getCustomerByIdentification(customer.getIdentification()).isPresent()) {
            return "S";
        }
        return customerRepository.createCustomer(customer);

    }


    @Override
    public String registerFaceplate(FaceplateDto faceplate) {
        if(faceplateRepository.getFaceplateByFaceplate(faceplate.getFaceplate()).isPresent()) {
            return "S";
        }
        return faceplateRepository.registerFaceplate(faceplate);
    }


    @Override
    public FaceplateDto getFaceplateByFaceplate(String faceplate) {
        Optional<Faceplate> faceplateResponse = faceplateRepository.getFaceplateByFaceplate(faceplate);
        FaceplateDto response = new FaceplateDto();
        if (!faceplateResponse.isPresent()) {
            return response;
        }
        response.setId(faceplateResponse.get().getId());
        response.setCustomerid(faceplateResponse.get().getCustomerid());
        response.setFaceplate(faceplateResponse.get().getFaceplate());
        return response;
    }


}
