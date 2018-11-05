package co.ppk.service;

import co.ppk.domain.Customer;
import co.ppk.dto.CustomerDto;
import co.ppk.dto.FaceplateDto;

import java.util.List;

public interface BusinessManager {
    CustomerDto getCustomerByIdentification(String identification);

    List<Customer> getCustomers();

    String createCustomer(CustomerDto customer);

    String registerFaceplate(FaceplateDto faceplate);

    FaceplateDto getFaceplateByFaceplate (String faceplate);
}
