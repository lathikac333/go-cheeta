package com.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.CustomerB;
import com.dao.CustomerDao;
import com.dto.response.UserDTO;
import com.dto.response.TripDetails;

@Service
public class CustomerBusinessImp implements CustomerB {

    @Autowired
    CustomerDao customerDao;
    
    @Override
    public UserDTO SelectedUserDtl(int userid) {
        return customerDao.SelectedUserDtl(userid);
    }

    @Override
    public List<TripDetails> UserTripHistory(int userid) {
        return customerDao.UserTripHistory(userid);
    }

    @Override
    public String UpdateUser(UserDTO user) {
        return null;
    }
    
}
