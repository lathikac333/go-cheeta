package com.business.impl.dao;

import java.util.List;

import com.dto.DBdto.Driverdto;
import com.dto.DBdto.summarycount;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripDetails;
import com.dto.response.VehicleDetailRes;

public interface AdminViewDao {
    
    public List<TripDetails> viewCurentTrips();
    public List<Driverdto> driverlist();
    public List<VehicleDetailRes> vehicleList();
    public summarycount summary();
    public List<VehicleCategoryReq> vehicleCategorylist();

    public GeneralResponse createDriver(Driverdto driverdto);
    public GeneralResponse createVehile(VehicleDetailRes vehicleDetailRes);
    public GeneralResponse createVCateg(VehicleCategoryReq vehiclecategory);
    public GeneralResponse createlocation(LocationRes LocationRes);

    public GeneralResponse updateDriver(Driverdto driverdto);
    public GeneralResponse updateVehile(VehicleDetailRes vehicleDetailRes);
    public GeneralResponse updateVCateg(VehicleCategoryReq vehiclecategory);
}
