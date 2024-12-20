package nature.sales_website.controllers;

import nature.sales_website.models.response.ActionStatus;
import nature.sales_website.models.response.ResponseData;
import nature.sales_website.servicesImpls.CustomerInfoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerInfoController {


    @Autowired
    CustomerInfoServiceImp customerInfoServiceImp;
    @PostMapping("/register")
    public ResponseEntity<ResponseData> Create(@RequestParam(value = "fullName") String fullName,
                                               @RequestParam(value = "email")  String email,
                                               @RequestParam(value ="message", required = false)  String message
                                               ){

        try {
            Object status = customerInfoServiceImp.customerRegister(fullName, email, message);
            return ActionStatus.data("Success", status, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return ActionStatus.exceptionData(e.getMessage());
        }
    }
}
