package com.dto.request;

public class UserReq {
    
    private int UserID;
    private int UserType;
    
    public int getUserID() {
        return UserID;
    }
    public void setUserID(int userID) {
        UserID = userID;
    }
    public int getUserType() {
        return UserType;
    }
    public void setUserType(int userType) {
        UserType = userType;
    }
}
