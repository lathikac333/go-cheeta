package com.business;

import com.dto.response.GeneralResponse;


public interface DriverBusiness {
    
    public GeneralResponse DriverCurentTrip(int driverid);

    public GeneralResponse TripRequst(int tripReq); 

    public GeneralResponse DriverHistory(int driverId);

    public GeneralResponse DriverDetails(int uReq);

}
