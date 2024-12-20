package nature.sales_website.servicesImpls;

import nature.sales_website.entity.CustomerInfo;
import nature.sales_website.repositories.CustomerRepository;
import nature.sales_website.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfoServiceImp implements CustomerInfoService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Object customerRegister(String fullName, String email, String message) {

        if (fullName == null | email == null ){
            throw  new RuntimeException("Name, email cannot be null!");
        }
        CustomerInfo customerInfo = new CustomerInfo();

        customerInfo.setFullName(fullName);
        customerInfo.setEmail(email);
        customerInfo.setMessage(message);

        return customerRepository.save(customerInfo);
    }
}
