package com.dto.response;

public class TripDetails {
    
    private int TripId;
    private int SourceLocationId;
    private String SourceLocation;
    private int DestinationLocationId;
    private String DestinationLocation;
    private String TravelDateTime;
    private Double TripFare;
    private String TripStatus;
    private int DriverId;
    private int BranchId;
    private String Branch;
    private int UserDetailid;
    private UserDTO Driver;
    private UserDTO User;
    
    public int getTripId() {
        return TripId;
    }
    public void setTripId(int tripId) {
        TripId = tripId;
    }
    public int getSourceLocationId() {
        return SourceLocationId;
    }
    public void setSourceLocationId(int sourceLocationId) {
        SourceLocationId = sourceLocationId;
    }
    public int getDestinationLocationId() {
        return DestinationLocationId;
    }
    public void setDestinationLocationId(int destinationLocationId) {
        DestinationLocationId = destinationLocationId;
    }
    public String getTravelDateTime() {
        return TravelDateTime;
    }
    public void setTravelDateTime(String travelDateTime) {
        TravelDateTime = travelDateTime;
    }
    public Double getTripFare() {
        return TripFare;
    }
    public void setTripFare(Double tripFare) {
        TripFare = tripFare;
    }
    public String getTripStatus() {
        return TripStatus;
    }
    public void setTripStatus(String tripStatus) {
        TripStatus = tripStatus;
    }
    public int getDriverId() {
        return DriverId;
    }
    public void setDriverId(int driverId) {
        DriverId = driverId;
    }
    public int getBranchId() {
        return BranchId;
    }
    public void setBranchId(int branchId) {
        BranchId = branchId;
    }
    public int getUserDetailid() {
        return UserDetailid;
    }
    public void setUserDetailid(int userDetailid) {
        UserDetailid = userDetailid;
    }
    public String getSourceLocation() {
        return SourceLocation;
    }
    public void setSourceLocation(String sourceLocation) {
        SourceLocation = sourceLocation;
    }
    public String getDestinationLocation() {
        return DestinationLocation;
    }
    public void setDestinationLocation(String destinationLocation) {
        DestinationLocation = destinationLocation;
    }
    public String getBranch() {
        return Branch;
    }
    public void setBranch(String branch) {
        Branch = branch;
    }
    public UserDTO getUser() {
        return User;
    }
    public void setUser(UserDTO user) {
        User = user;}
    public UserDTO getDriver() {
        return Driver;
    }
    public void setDriver(UserDTO driver) {
        Driver = driver;
    }


}
