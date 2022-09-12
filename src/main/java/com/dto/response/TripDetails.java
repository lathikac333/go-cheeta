package com.dto.response;

public class TripDetails {
    
    private int TripId;
    private int SourceLocationId;
    private int DestinationLocationId;
    private String TravelDateTime;
    private Double TripFare;
    private String TripStatus;
    private int DriverId;
    private int BranchId;
    private int UserDetailid;
    
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


}
