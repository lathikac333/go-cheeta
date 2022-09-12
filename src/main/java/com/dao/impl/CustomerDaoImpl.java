package com.dao.impl;

import com.dao.CustomerDao;
import com.dto.response.TripDetails;
import com.dto.response.UserDTO;
import com.dto.request.UserReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UserDTO SelectedUserDtl(UserReq userreq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UserDTO user = new UserDTO();
        try {
            String selectuserbyidtype = "select * from userdetail where UserDetailId = '"+userreq.getUserID()+"' and UserType = '"+userreq.getUserType()+"'";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectuserbyidtype);
            while (resultSet.next()){
                user.setUserid(resultSet.getInt("UserDetailId"));
                user.setfName(resultSet.getString("FirstName"));
                user.setlName(resultSet.getString("LastName"));
                user.setAddress(resultSet.getString("Address"));
                user.setEmail(resultSet.getString("EmailAddress"));
                user.setMobilenumber(resultSet.getString("MobileNumber"));
                user.setuPassword(resultSet.getString("UserPassword"));
                user.setuType(resultSet.getInt("UserType"));                
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
        return user;
    }

    @Override
    public List<TripDetails> UserTripHistory(UserReq userreq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<TripDetails> Triplist = new ArrayList<>();
        try {
            String selectuserbyidtype = "select * from trip where UserDetailid = '"+userreq.getUserID()+"' order by TripId desc";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
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
    public String UpdateUser(UserDTO user) {
        return null;
    }
    
}
