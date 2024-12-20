package nature.sales_website.services;


import org.springframework.stereotype.Service;

@Service
public interface CustomerInfoService {

    Object customerRegister(String fullName, String email, String message);
}
