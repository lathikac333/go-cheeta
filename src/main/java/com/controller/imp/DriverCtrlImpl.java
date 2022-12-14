package com.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.business.DriverBusiness;
import com.business.TripBusiness;
import com.controller.DriverCtrl;
import com.dto.request.TripDetailReq;
import com.dto.response.GeneralResponse;

@RestController
@CrossOrigin("*")
public class DriverCtrlImpl implements DriverCtrl {

    @Autowired
    private DriverBusiness dBusiness;
    @Autowired
    private TripBusiness tripBusiness;

    @Override
    @PostMapping("/driver/currenttrip")
    public GeneralResponse DriverCurentTrip(@RequestBody  int driverid) {
        return dBusiness.DriverCurentTrip(driverid);
    }

    @Override
    @PostMapping("/driver/triprequest")
    public GeneralResponse TripRequst(@RequestBody int tripReq) {
        return dBusiness.TripRequst(tripReq);
    }

    @Override
    @PostMapping("/driver/driverhistory")
    public GeneralResponse DriverHistory(@RequestBody int driverId) {
        return dBusiness.DriverHistory(driverId);
    }

    @Override
    @PostMapping("/driver/driverdetails")
    public GeneralResponse DriverDetails(@RequestBody int uReq) {
        return dBusiness.DriverDetails(uReq);
    }

    @Override
    @PostMapping("/driver/modifyddetails")
    public GeneralResponse modifyDriverDetails() {
        return null;
    }

    @Override
    @PostMapping("/driver/tripconfirm")
    public GeneralResponse confirmTrip(@RequestBody TripDetailReq driverRes) {
        return tripBusiness.assignDriverToTrip(driverRes);
    }

    @Override
    @PostMapping("/driver/tripcancel")
    public GeneralResponse cancelTrip(@RequestBody TripDetailReq driverRes) {
        return tripBusiness.cancelTrip(driverRes, "canceled");
    }

    @Override
    @PostMapping("/driver/tripStart")
    public GeneralResponse StartTrip(@RequestBody TripDetailReq driverRes) {
        return tripBusiness.cancelTrip(driverRes, "onTrip");
    }

    @Override
    @PostMapping("/driver/tripClose")
    public GeneralResponse TripClose(@RequestBody TripDetailReq driverRes) {
        return tripBusiness.cancelTrip(driverRes, "closed");
    }
    
}
