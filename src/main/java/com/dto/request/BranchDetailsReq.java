package com.dto.request;

public class BranchDetailsReq {

    private int BranchId ;
    private String BranchName;

    public  int getID() { return this.BranchId; }
    public  void setBranchId(int branchId) { this.BranchId = branchId; }

    public  String getBranchName(){return this.BranchName; }
    public  void    setBranchName(String branchName ){ this.BranchName =branchName ; }

}
