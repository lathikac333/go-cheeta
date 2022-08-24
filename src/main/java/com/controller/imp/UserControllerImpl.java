package com.controller.imp;

import com.business.UserBusiness;
import com.controller.UserController;
import com.dto.request.CustomerLoginReq;
import com.dto.request.DriverRegistrationReq;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserControllerImpl implements UserController {

    @Autowired
    UserBusiness userBusiness;

    @Override
    @PostMapping("/create/customer")
    public GeneralResponse userRegistration(@RequestBody UserRegistrationReq userRegistrationReq) {
        return userBusiness.userRegistration(userRegistrationReq);
    }

    @Override
    @PostMapping("/login/user")
    public GeneralResponse userLogin(@RequestBody CustomerLoginReq customerLoginReq) {
        return userBusiness.userLogin(customerLoginReq);
    }

    @Override
    @PostMapping("/create/driver")
    public GeneralResponse driverRegistration(@RequestBody DriverRegistrationReq driverRegistrationReq) {
        return userBusiness.driverRegistration(driverRegistrationReq);
    }
}
