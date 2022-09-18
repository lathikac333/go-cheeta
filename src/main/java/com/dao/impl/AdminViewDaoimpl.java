package com.business.impl.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.business.impl.dao.AdminViewDao;
import com.dto.DBdto.Driverdto;
import com.dto.DBdto.summarycount;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripDetails;
import com.dto.response.VehicleDetailRes;

@Repository
public class AdminViewDaoimpl implements AdminViewDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    @Override
    public List<TripDetails> viewCurentTrips() {
        List<TripDetails> TripDetails = new ArrayList<>();        
        try 
        { 
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.curenttrips);
            while (resultSet.next()){
                TripDetails Trip = new TripDetails();
                Trip.setBranchId(resultSet.getInt("BranchId"));
                Trip.setDestinationLocationId(resultSet.getInt("DestinationLocationId"));
                Trip.setDriverId(resultSet.getInt("DriverId"));
                Trip.setSourceLocationId(resultSet.getInt("SourceLocationId"));
                Trip.setTravelDateTime(resultSet.getString("TravelDateTime"));
                Trip.setTripFare(resultSet.getDouble("TripFare"));
                Trip.setUserDetailid(resultSet.getInt("UserDetailid"));
                Trip.setTripStatus(resultSet.getString("TripStatus"));     
                Trip.setTripId(resultSet.getInt("TripId"));
                TripDetails.add(Trip);
            }
        } catch (Exception e) {  }
        finally {
            try {  connection.close(); statement.close(); } catch (SQLException e) {  }
        }
        return TripDetails;
    }

    @Override
    public List<Driverdto> driverlist() {
        List<Driverdto> Driverdto = new ArrayList<>();        
        try 
        { 
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.drivers);
            while (resultSet.next()){
                Driverdto Driver = new Driverdto();
                Driver.setBranchId(resultSet.getInt("BranchId"));
                Driver.setDriverId(resultSet.getInt("DriverId"));
                Driver.setUserDetailId(resultSet.getInt("UserDetailId"));
                Driver.setVehicleDetailId(resultSet.getInt("VehicleDetailId")); 
                Driverdto.add(Driver);
            }
        } catch (Exception e) {  }
        finally {
            try {  connection.close(); statement.close(); } catch (SQLException e) {  }
        }
        return Driverdto;
    }

    @Override
    public List<VehicleDetailRes> vehicleList() {
        List<VehicleDetailRes> VehicleDetailRes = new ArrayList<>();        
        try 
        { 
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.vehicles);
            while (resultSet.next()){
                VehicleDetailRes Vehicle = new VehicleDetailRes();
                Vehicle.setBrandName(resultSet.getString("BrandName"));
                Vehicle.setModelName(resultSet.getString("ModelName"));
                Vehicle.setVehicleCategoryid(resultSet.getInt("VehicleCategoryId"));
                Vehicle.setVehicleDetailId(resultSet.getInt("VehicleDetailId"));
                VehicleDetailRes.add(Vehicle);
            }
        } catch (Exception e) {  }
        finally {
            try {  connection.close(); statement.close(); } catch (SQLException e) {  }
        }
        return VehicleDetailRes;
    }

    @Override
    public summarycount summary() {        
        summarycount counts = new summarycount();
        try 
        {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.tripscount);
            while (resultSet.next()){
                counts.setTrips(resultSet.getInt(1));
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.usercount);
            while (resultSet.next()){
                counts.setUsers(resultSet.getInt(1));
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.drivercount);
            while (resultSet.next()){
                counts.setDrivers(resultSet.getInt(1));
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.vehiclecount);
            while (resultSet.next()){
                counts.setVehicles(resultSet.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        finally {
            try {  connection.close(); statement.close(); } catch (SQLException e) {  }
        }
        return counts;
    }
    
    @Override
    public List<VehicleCategoryReq> vehicleCategorylist() {
        List<VehicleCategoryReq> VehicleCategoryReq = new ArrayList<>();        
        try 
        { 
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.iAdmin.curenttrips);
            while (resultSet.next()){
                VehicleCategoryReq VehicleCategory = new VehicleCategoryReq();
                VehicleCategory.setVehicleCategoryId(resultSet.getInt("VehicleCategoryId"));
                VehicleCategory.setVehicleCategoryName(resultSet.getString("VehicleCategoryName"));   
                VehicleCategoryReq.add(VehicleCategory);
            }
        } catch (Exception e) {  }
        finally {
            try {  connection.close(); statement.close(); } catch (SQLException e) {  }
        }
        return VehicleCategoryReq;
    }





    @Override
    public GeneralResponse createDriver(Driverdto driverdto) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.iAdmin.insertdriver
            );
            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public GeneralResponse createVehile(VehicleDetailRes vehicleDetailRes) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.iAdmin.insertvehicle
            );
            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public GeneralResponse createVCateg(VehicleCategoryReq vehiclecategory) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.iAdmin.insertvehiclecateg
            );
            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public GeneralResponse createlocation(LocationRes LocationRes) {
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.iAdmin.insertlocation
            );
            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }




    @Override
    public GeneralResponse updateDriver(Driverdto driverdto) {
        GeneralResponse commonResponse = null;        
        return commonResponse;
    }

    @Override
    public GeneralResponse updateVehile(VehicleDetailRes vehicleDetailRes) {
        GeneralResponse commonResponse = null;        
        return commonResponse;
    }

    @Override
    public GeneralResponse updateVCateg(VehicleCategoryReq vehiclecategory) {
        GeneralResponse commonResponse = null;        
        return commonResponse;
    }

    
    
}
