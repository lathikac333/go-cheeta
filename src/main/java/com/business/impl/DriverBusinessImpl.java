package com.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.DriverBusiness;
import com.dao.CustomerDao;
import com.dao.DriverDao;
import com.dto.response.GeneralResponse;
import com.dto.response.TripDetails;
import com.dto.response.UserDTO;
import com.dto.response.UserDriverDto;

@Service
public class DriverBusinessImpl implements DriverBusiness {

    @Autowired
    private DriverDao driverDao;
    @Autowired
    private CustomerDao customerDao;
    
    @Override
    public GeneralResponse TripRequst(int tripReq) {
        List<TripDetails> tl1 = driverDao.TripRequst("booked", tripReq, 0);
        return GeneralResponse.generateResponse(tl1, 1000, "Success");
    }

    @Override
    public GeneralResponse DriverHistory(int driverId) {
        List<TripDetails> tl = driverDao.DriverHistory(driverId);
        return GeneralResponse.generateResponse(tl,1000,"Success");
    }

    @Override
    public GeneralResponse DriverDetails(int uReq) {
        UserDTO user = customerDao.SelectedUserDtl(uReq);
        UserDriverDto udd = driverDao.DriverDetails(user.getUserid());
        udd.setAddress(user.getAddress());
        udd.setEmail(user.getEmail());
        udd.setMobilenumber(user.getMobilenumber());
        udd.setfName(user.getfName());
        udd.setlName(user.getlName());
        return GeneralResponse.generateResponse(udd, 1000, "Success");
    }

    @Override
    public GeneralResponse DriverCurentTrip(int driverid) {
        List<TripDetails> tl1 = driverDao.TripRequst("confirmed", 0, driverid);
        return GeneralResponse.generateResponse(tl1, 1000, "Success");
    }
    
}
