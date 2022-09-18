package com.controller;

import com.dto.response.GeneralResponse;

public interface AdminCtrl {
    
    public GeneralResponse viewCurentTrips();
    public GeneralResponse driverlist();
    public GeneralResponse vehicleList();
    public GeneralResponse summary();
    public GeneralResponse vehicleCategorylist();
}
