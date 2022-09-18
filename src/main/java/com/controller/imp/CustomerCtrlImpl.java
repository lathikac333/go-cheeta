package com.controller.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.response.GeneralResponse;
import com.business.CustomerB;
import com.controller.CustomerCtrl;
import com.dto.response.UserDTO;

@RestController
@CrossOrigin("*")
public class CustomerCtrlImpl implements CustomerCtrl  {

    @Autowired
    CustomerB customerB;
    
    ObjectMapper mapper = new ObjectMapper();

    @Override
    @PostMapping("/customer/detail")
    public GeneralResponse getSelectedUser(@RequestBody  int userreq) {
        //int uid = 7;
        UserDTO usr = customerB.SelectedUserDtl(userreq);
        try {
            //mapper.writeValue(new File("person.json"), usr);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(usr);
            System.out.println("customer/detail");
            System.out.println(jsonString);
        } catch (Exception e) {
        }        
        return GeneralResponse.generateResponse(usr,1000,"Success");
        
    }

    @Override
    @PostMapping("/customer/triphistory")
    public GeneralResponse getttripHistory(@RequestBody int userreq) {
        //int uid = 7;
        return customerB.UserTripHistory(userreq);
    }

    @Override
    @PostMapping("/customer/currenttrip")
    public GeneralResponse onGoingtrip(@RequestBody  int userreq) {        
        return customerB.ongoingTrip(userreq);        
    }

    @Override
    public String updateUserDetail(@RequestBody UserDTO user) {
        return null;
    }
    
}
