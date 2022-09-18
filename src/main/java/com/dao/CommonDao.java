package com.business.impl.dao;

import com.dto.DBdto.Driverdto;
import com.dto.request.BranchDetailsReq;
import com.dto.request.UserRegistrationReq;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.VehicleDetailRes;

public interface CommonDao {
    
    public BranchDetailsReq getBranchbyid(int bID);
    public String getLocationbyid(int lId);
    public VehicleDetailRes getVehiclebyid(int vId);
    public VehicleCategoryReq Vehiclecategorybyid(int vcId);
    public Driverdto getDriverbyid(int dId);
    public UserRegistrationReq getuserbyID(int uid);
}
