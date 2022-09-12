package com.controller;

import com.dto.request.UserReq;
import com.dto.response.GeneralResponse;

public interface DriverCtrl {
    
    public GeneralResponse getDriverHistory(UserReq driverreq);
    public GeneralResponse getDriverDetails(UserReq driverreq);
    public GeneralResponse modifyDriverDetails();
    public GeneralResponse tripRequest();
    public GeneralResponse confirmTrip();
    public GeneralResponse cancelTrip();

}
