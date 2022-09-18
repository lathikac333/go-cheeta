package com.dto.DBdto;

import com.dto.request.BranchDetailsReq;
import com.dto.response.UserDTO;
import com.dto.response.VehicleDetailRes;

public class Driverdto {
    
   private int DriverId;
   private int UserDetailId;
   private int VehicleDetailId;
   private int BranchId;
   
   private UserDTO UserDetail;
   private VehicleDetailRes VehicleDetail;
   private BranchDetailsReq Branch;

public int getDriverId() {
    return DriverId;
}
public void setDriverId(int driverId) {
    DriverId = driverId;
}
public int getUserDetailId() {
    return UserDetailId;
}
public void setUserDetailId(int userDetailId) {
    UserDetailId = userDetailId;
}
public int getVehicleDetailId() {
    return VehicleDetailId;
}
public void setVehicleDetailId(int vehicleDetailId) {
    VehicleDetailId = vehicleDetailId;
}
public int getBranchId() {
    return BranchId;
}
public void setBranchId(int branchId) {
    BranchId = branchId;
}
public UserDTO getUserDetail() {
    return UserDetail;
}
public void setUserDetail(UserDTO userDetail) {
    UserDetail = userDetail;
}
public VehicleDetailRes getVehicleDetail() {
    return VehicleDetail;
}
public void setVehicleDetail(VehicleDetailRes vehicleDetail) {
    VehicleDetail = vehicleDetail;
}
public BranchDetailsReq getBranch() {
    return Branch;
}
public void setBranch(BranchDetailsReq branch) {
    Branch = branch;
}
}
