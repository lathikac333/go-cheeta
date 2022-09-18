package com.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.DriverBusiness;
import com.business.impl.dao.CustomerDao;
import com.business.impl.dao.DriverDao;
import com.business.impl.dao.CommonDao;
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
    @Autowired
    private CommonDao CommonDao;
    
    @Override
    public GeneralResponse TripRequst(int tripReq) {
        List<TripDetails> tl1 = driverDao.TripRequst("booked", tripReq, 0);
        for (TripDetails tripDetails : tl1) {            
            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));
        }
        return GeneralResponse.generateResponse(tl1, 1000, "Success");
    }

    @Override
    public GeneralResponse DriverHistory(int driverId) {
        List<TripDetails> tl = driverDao.DriverHistory(driverId);
        for (TripDetails tripDetails : tl) {
            
            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));
        }
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
        for (TripDetails tripDetails : tl1) {            
            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));

            //Driverdto d = CommonDao.getDriverbyid(driverid);
            tripDetails.setUser(customerDao.SelectedUserDtl(tripDetails.getUserDetailid()));
        }
        return GeneralResponse.generateResponse(tl1, 1000, "Success");
    }    
}
