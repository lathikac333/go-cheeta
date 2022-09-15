package com.dto.request;

public class TripReqestDTO {
    
    private int branchId;
    private String Status;
    
    public int getBranchId() {
        return branchId;
    }
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
}
