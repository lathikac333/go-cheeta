package com.business.impl.dao.impl;

public class ApplicationDAOContant {
    interface IVehicle{
        String INSERT_VEHICLE_CATEGORY = "insert into vehiclecategory(VehicleCategoryName) VALUES (?)";
        String GET_VEHICLE_CATEGORIES = "select VehicleCategoryId,VehicleCategoryName from vehiclecategory";

        String INSERT_VEHICLE_DETAIL = "insert into vehicledetail(BrandName, ModelName, VehicleCategoryId) VALUES (?,?,?)";

        String GET_VEHICLE_DETAIL = "select vd.VehicleDetailid,vd.BrandName,vd.ModelName,v.VehicleCategoryName from vehicledetail vd inner join vehiclecategory v on vd.VehicleCategoryId = v.VehicleCategoryId where VehicleDetailId = ";

        String GET_VEHICLE_DETAIL_LIST = "select vd.BrandName,vd.ModelName,v.VehicleCategoryName from vehicledetail vd inner join vehiclecategory v on vd.VehicleCategoryId = v.VehicleCategoryId";
    }

    interface ITrip{
        String INSERT_TRIP = "insert into trip(SourceLocationId, DestinationLocationId, TravelDateTime, TripFare, TripStatus, BranchId, UserDetailId) VALUES (?,?,?,?,?,?,?)";

        String Asign_TRIP = "update trip set TripStatus = ? , DriverId = ? where TripId = ?";

        String CANCEL_TRIP = "";

        String TRIP_LIST = "";

        String TRIP_DETAIL = "";
        String GET_LOCATIONS = "select * from location";
        String GET_LOCATIONS_BY_CITY = "select LocationId, StreetAddress from location where City = ";

        String Get_BranchName = "select BranchName from branch";
    }

    interface iCustomer{

        String selectedcustomerDetails = "select * from userdetail where UserDetailId = ";
        String selecteduserTripHistory = "select * from trip where UserDetailid = ";
        String selectedcustomerCurrentTrip = "";
        String updateCustomerDetails = "";
    }

    interface iAdmin{
        String curenttrips = "select * from trip where TripStatus in('confirmed', 'onTrip')";
        String drivers = "select * from driver";
        String vehicles = "select * from vehicledetail";
        String vehiclecategs = "select * from vehiclecategory";
        String tripscount = "select count(TripId) from trip";
        String usercount = "select count(UserDetailId)  from userdetail";
        String drivercount = "select count(DriverId)  from driver";
        String vehiclecount = "select count(VehicleDetailId)  from vehicledetail";
        String insertdriver = "insert into driver() VALUES (?,?)";
        String insertvehicle = "insert into vehicledetail() VALUES (?,?)";
        String insertvehiclecateg = "insert into vehiclecategory() VALUES (?,?)";
        String insertlocation = "insert into location() VALUES (?,?)";

    }
}
