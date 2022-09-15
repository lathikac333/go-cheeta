package com.controller;

import com.dto.response.GeneralResponse;

public interface DriverCtrl {
    
    public GeneralResponse DriverCurentTrip(int driverid);

    public GeneralResponse TripRequst(int tripReq); 

    public GeneralResponse DriverHistory(int driverId);

    public GeneralResponse DriverDetails(int uReq);

    public GeneralResponse modifyDriverDetails();
    public GeneralResponse confirmTrip();
    public GeneralResponse cancelTrip();
}
