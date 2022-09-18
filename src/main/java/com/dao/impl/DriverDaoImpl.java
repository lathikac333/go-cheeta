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
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.business.impl.dao.DriverDao;
import com.dto.response.TripDetails;
import com.dto.response.UserDriverDto;

@Repository
public class DriverDaoImpl implements DriverDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<TripDetails> TripRequst(String status, @Nullable int BranchId, @Nullable int duserId) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TripDetails> Triplist = new ArrayList<>();
        int driverid=0;

        try{
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select DriverId from driver where UserDetailId = '"+duserId+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                driverid =resultSet.getInt(1);
                System.out.println("Driver id -" + driverid );
                }
                String stuswithBranch = "select * from trip where BranchId = '"+BranchId+"' and TripStatus  = '"+status+"' order by TripId desc";
                String stuswithDriver = "select * from trip where DriverId = '"+driverid+"' and TripStatus in ('confirmed', 'onTrip') order by TripId desc";
                String Quary;
                if(BranchId > 0)
                {
                    Quary = stuswithBranch;
                }
                else
                {
                    Quary = stuswithDriver;
                }
 
                resultSet = statement.executeQuery(Quary);
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

                Triplist.add(Trip);
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
        return Triplist;
    }

    @Override
    public List<TripDetails> DriverHistory(int duserId) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TripDetails> Triplist = new ArrayList<>();
        int driverid = 0;
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            String query = "select DriverId from driver where UserDetailId = '"+duserId+"'";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                driverid =resultSet.getInt(1);
                System.out.println("Driver id -" + driverid );
            }

            String selectuserbyidtype = "select * from trip where DriverId = '"+driverid+"' order by TripId desc";
            //connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            //statement = connection.createStatement();
            resultSet = statement.executeQuery(selectuserbyidtype);
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
                
                Triplist.add(Trip);
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
        return Triplist;
    }

    @Override
    public UserDriverDto DriverDetails(int uReq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UserDriverDto udriver = new UserDriverDto();
        try {
            String SELECT_driverbyuser = "select * from driver where UserDetailId = '"+uReq+"'";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_driverbyuser);
            while (resultSet.next()){
                udriver.setDriverId(resultSet.getInt("DriverId"));
                udriver.setUserid(resultSet.getInt("UserdetailId"));
                udriver.setVehileId(resultSet.getInt("VehicleDetailId"));
                udriver.setBranchId(resultSet.getInt("BranchId"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {}
        }
        return udriver;
    }
    
}
