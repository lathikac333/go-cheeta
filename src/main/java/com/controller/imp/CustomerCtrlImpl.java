package com.controller.imp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.controller.*;
import com.dao.CustomerDao;
import com.dto.request.UserReq;
import com.dto.response.*;

public class CustomerCtrlImpl implements CustomerCtrl  {

    @Autowired
    CustomerDao customerDao;

    @Override
    @GetMapping("/customer/detail/{userreq}")
    public GeneralResponse getSelectedUser(@PathVariable UserReq userreq) {
        UserDTO usr = customerDao.SelectedUserDtl(userreq);
        return GeneralResponse.generateResponse(usr,1000,"Success");
        
    }

    @Override
    @GetMapping("/customer/triphistory/{userreq}")
    public GeneralResponse getttripHistory(@PathVariable UserReq userreq) {
        List<TripDetails> ff = customerDao.UserTripHistory(userreq);
        return GeneralResponse.generateResponse(ff,1000,"Success");
    }

    @Override
    @GetMapping("/customer/currenttrip/{userreq}")
    public GeneralResponse onGoingtrip(@PathVariable UserReq userreq) {
        TripDetails trip = new TripDetails();
        List<TripDetails> ff = customerDao.UserTripHistory(userreq);
        for (TripDetails tripDetails : ff) {
            if(tripDetails.getTripStatus().toLowerCase() != "closed")
            {
                trip = tripDetails;
            };
        } 
        return GeneralResponse.generateResponse(trip,1000,"Success");        
    }

    @Override
    public String updateUserDetail(UserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
