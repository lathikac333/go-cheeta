package com.business;

import com.dto.response.GeneralResponse;

public interface AdminBusiness {
    
    public GeneralResponse viewCurentTrips();
    public GeneralResponse driverlist();
    public GeneralResponse vehicleList();
    public GeneralResponse summary();
    public GeneralResponse vehicleCategorylist();
    
}
