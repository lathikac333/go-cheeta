package com.controller.imp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.response.GeneralResponse;
import com.dto.response.TripDetails;
import com.business.CustomerB;
import com.controller.CustomerCtrl;
import com.dto.response.UserDTO;

@RestController
@CrossOrigin("*")
public class CustomerCtrlImpl implements CustomerCtrl  {

    @Autowired
    CustomerB customerB;

    @Override
    @PostMapping("/customer/detail")
    public GeneralResponse getSelectedUser(@RequestBody  int userreq) {
        //int uid = 7;
        UserDTO usr = customerB.SelectedUserDtl(userreq);
        return GeneralResponse.generateResponse(usr,1000,"Success");
        
    }

    @Override
    @PostMapping("/customer/triphistory")
    public GeneralResponse getttripHistory(@RequestBody int userreq) {
        //int uid = 7;
        List<TripDetails> ff = customerB.UserTripHistory(userreq);
        return GeneralResponse.generateResponse(ff,1000,"Success");
    }

    @Override
    @PostMapping("/customer/currenttrip")
    public GeneralResponse onGoingtrip(@RequestBody  int userreq) {
        TripDetails trip = new TripDetails();
        //int uid = 7;
        List<TripDetails> ff = customerB.UserTripHistory(userreq);
        for (TripDetails tripDetails : ff) {
            String stus = tripDetails.getTripStatus().toLowerCase();
            if( stus == "confirmed" || stus == "ontrip" )
            {
                trip = tripDetails;
            };
        } 
        return GeneralResponse.generateResponse(trip,1000,"Success");        
    }

    @Override
    public String updateUserDetail(@RequestBody UserDTO user) {
        return null;
    }
    
}
