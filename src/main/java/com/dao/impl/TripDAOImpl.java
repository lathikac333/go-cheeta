package com.business.impl.dao.impl;

import com.business.impl.dao.TripDAO;
import com.dto.request.CreateTripReq;
import com.dto.request.GetLocationByCityReq;
import com.dto.request.TripDetailReq;
import com.dto.response.BranchDetailRes;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripRes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripDAOImpl implements TripDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    ObjectMapper mapper = new ObjectMapper();


    @Override
    @Transactional
    public GeneralResponse createNewTrip(CreateTripReq createTripReq) {
        try{
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createTripReq);
        System.out.println("customer/triphistory");
        System.out.println(jsonString);}
        catch (Exception e){}

        GeneralResponse commonResponse = null;
         Connection connection = null;
         Statement statement = null;
         ResultSet resultSet = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.ITrip.INSERT_TRIP,
                    createTripReq.getSourceLocationId(),
                    createTripReq.getDestinationLocationId(),
                    createTripReq.getTravelDateTime(),
                    calculateCost(),
                    "booked",
                    createTripReq.getBranchId(),
                    createTripReq.getUserDetailId()
            );

            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to create the trip, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,500,"Unable to create the trip, please try again...!");
        }
        return commonResponse;
    }

    double calculateCost(){
        return 149.99;
    }

    @Override
    @Transactional
    public GeneralResponse assignDriverToTrip(TripDetailReq TripDetailReq) {
         Connection connection = null;
         Statement statement = null;
         ResultSet resultSet = null;
        System.out.println(TripDetailReq.getDriverUserId() + ", "+ TripDetailReq.getTripId());
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        int driverid = 0;
        try{
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select DriverId from driver where UserDetailId = '"+TripDetailReq.getDriverUserId()+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                driverid =resultSet.getInt(1);
                System.out.println("Driver id -" + driverid );
            }

            int tripid = 0;
            String query2 = "select TripId from trip where TripStatus in ('confirmed', 'onTrip') and DriverId = '"+driverid+"'";
            resultSet = statement.executeQuery(query2);
            while (resultSet.next()){
                tripid =resultSet.getInt(1);
                System.out.println("Tripid id -" + tripid );
            }

            if(tripid <= 0){
                isInserted = jdbcTemplate.update(ApplicationDAOContant.ITrip.Asign_TRIP,
                "confirmed",
                driverid,
                TripDetailReq.getTripId()
                );
            }            

            if(isInserted == 1){
                commonResponse = new GeneralResponse(null,1000,"Success");
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to asign the trip to driver, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to asign the trip to driver, please try again...!");
        }
        return commonResponse;
    }

    @Override
    @Transactional
    public GeneralResponse editTrip(TripDetailReq TripDetailReq, String Status) {
         Connection connection = null;
         Statement statement = null;
         ResultSet resultSet = null;
        System.out.println(TripDetailReq.getDriverUserId() + ", "+ TripDetailReq.getTripId());
        GeneralResponse commonResponse = null;
        int isInserted = 0;
        int driverid = 0;
        try{
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select DriverId from driver where UserDetailId = '"+TripDetailReq.getDriverUserId()+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                driverid =resultSet.getInt(1);
                System.out.println("Driver id -" + driverid );
            }

                isInserted = jdbcTemplate.update(ApplicationDAOContant.ITrip.Asign_TRIP,
                Status,
                driverid,
                TripDetailReq.getTripId()
                );     

            if(isInserted == 1){
                String sts = "Success - Trip" + Status +"!"; 
                commonResponse = new GeneralResponse(null,1000,sts);
            }else {
                commonResponse = new GeneralResponse(null,1001,"Unable to asign the trip to driver, please try again...!");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            commonResponse = new GeneralResponse(null,1001,"Unable to asign the trip to driver, please try again...!");
        }
        return commonResponse;
    }

    @Override
    public List<TripRes> getTripList() {
        return null;
    }

    @Override
    public TripRes getTripDetail(TripDetailReq tripDetailReq) {
        return null;
    }

    @Override
    public List<LocationRes> getLocationList() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<LocationRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.ITrip.GET_LOCATIONS);
            while (resultSet.next()){
                LocationRes res = new LocationRes();
                res.setLocationId(resultSet.getInt("LocationId"));
                res.setStreetAddress(resultSet.getString("StreetAddress"));
                res.setCity(resultSet.getString("City"));
                res.setLocationName(resultSet.getString("LocationName"));
                res.setBranchId(resultSet.getInt("BranchId"));

                list.add(res);
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    public List<LocationRes> getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<LocationRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select LocationId, StreetAddress from location where City = '"+getLocationByCityReq.getCity()+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                LocationRes res = new LocationRes();
                res.setLocationId(resultSet.getInt(1));
                res.setStreetAddress(resultSet.getString(2));

                list.add(res);
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    public List<BranchDetailRes> getBranchDetail()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<BranchDetailRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select BranchId,BranchName from branch" ;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                BranchDetailRes res = new BranchDetailRes();
                res.setBranchId(resultSet.getInt(1));
                res.setBranchName(resultSet.getString(2));
                list.add(res);
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    /* (non-Javadoc)
     * @see com.dao.TripDAO#getBarchName()
     */
    @Override
    public String getBarchName() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String Name = new String();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            //String query = "select BranchName from branch" ;
            resultSet = statement.executeQuery(ApplicationDAOContant.ITrip.Get_BranchName);
            while (resultSet.next()){
                BranchDetailRes res = new BranchDetailRes();
                res.setBranchName(resultSet.getString(1));
                Name = res.getBranchName();
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
            }
        }
        return Name;
    }


}
