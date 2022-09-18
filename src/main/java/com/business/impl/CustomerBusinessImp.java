package com.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.CustomerB;
import com.business.impl.dao.CommonDao;
import com.business.impl.dao.CustomerDao;
import com.dto.response.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.response.GeneralResponse;
import com.dto.response.TripDetails;

@Service
public class CustomerBusinessImp implements CustomerB {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CommonDao CommonDao;

    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public UserDTO SelectedUserDtl(int userid) {
        return customerDao.SelectedUserDtl(userid);
    }

    @Override
    public GeneralResponse UserTripHistory(int userid) {       
        List<TripDetails> ff = customerDao.UserTripHistory(userid);
        
        //String xxx = CommonDao.getBranchbyid(Trip.getBranchId()).getBranchName();
        for (TripDetails tripDetails : ff) {

            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));
        }
        
        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ff);
            System.out.println("customer/triphistory");
            System.out.println(jsonString);
        } catch (Exception e) {
        }
        
        return GeneralResponse.generateResponse(ff,1000,"Success");
    }

    @Override
    public String UpdateUser(UserDTO user) {
        return null;
    }
    
    @Override
    public GeneralResponse ongoingTrip(int userid)
    {
        TripDetails trip = new TripDetails();
        //int uid = 7;
        List<TripDetails> ff = customerDao.UserTripHistory(userid);
        for (TripDetails tripDetails : ff) {
            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));

            tripDetails.setUser(customerDao.SelectedUserDtl(tripDetails.getUserDetailid()));
            System.out.println(tripDetails.getUserDetailid() + tripDetails.getTripStatus());
            String stus = tripDetails.getTripStatus().toLowerCase();
            if( stus.equals("confirmed") || stus.equals("ontrip"))
            {
                System.out.println(tripDetails.getTripStatus());
                trip = tripDetails;
            };
        } 
        try {
            //mapper.writeValue(new File("person.json"), usr);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trip);
            System.out.println("customer/currenttrip");
            System.out.println(jsonString);
        } catch (Exception e) {
        }
        return GeneralResponse.generateResponse(trip,1000,"Success"); 
    }
}
