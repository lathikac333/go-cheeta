package com.dto.request;

public class VehicleCategoryReq {
    private String vehicleCategoryName;
    private int VehicleCategoryId;

    public int getVehicleCategoryId() {
        return VehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        VehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }
}
