package com.business.impl.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.business.impl.dao.CommonDao;
import com.dto.DBdto.Driverdto;
import com.dto.request.BranchDetailsReq;
import com.dto.request.UserRegistrationReq;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.VehicleDetailRes;

@Repository
public class CommonDaoImpl implements CommonDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    @Override
    public BranchDetailsReq getBranchbyid(int bID) {        
        BranchDetailsReq result = new BranchDetailsReq();
        try {
            String Quary = "select * from branch where BranchId = '"+bID+"' ";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Quary);
            while (resultSet.next()){
                result.setBranchName(resultSet.getString("BranchName"));
                result.setBranchId(resultSet.getInt("BranchId"));              
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
        return result;
    }

    @Override
    public String getLocationbyid(int lId) {
        String result = null;
        try {
            String Quary = "select * from location where LocationId = '"+lId+"' ";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Quary);
            while (resultSet.next()){
                //result = resultSet.getString("LocationName");
                result = resultSet.getString("StreetAddress");
                //result = resultSet.getString("City");
                //result = resultSet.getString("StreetAddress");
                //int r1 = resultSet.getInt("BranchId");     
                //int r1 = resultSet.getInt("LocationId");          
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
        return result;
    }

    @Override
    public VehicleDetailRes getVehiclebyid(int vId) {
        VehicleDetailRes result = new VehicleDetailRes();
        try {
            String Quary = "select * from vehicledetail where VehicleDetailId = '"+vId+"' ";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Quary);
            while (resultSet.next()){
                result.setBrandName(resultSet.getString("BrandName"));
                result.setModelName(resultSet.getString("ModelName"));
                result.setVehicleCategoryid(resultSet.getInt("VehicleCategoryId"));
                result.setVehicleDetailId(resultSet.getInt("VehicleDetailId"));                        
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
        return result;
    }

    @Override
    public Driverdto getDriverbyid(int dId) {
        Driverdto result = new Driverdto();
        try {
            String Quary = "select * from driver where DriverId = '"+dId+"' ";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Quary);
            while (resultSet.next()){
                result.setBranchId(resultSet.getInt("BranchId"));
                result.setDriverId(resultSet.getInt("DriverId"));
                result.setUserDetailId(resultSet.getInt("UserDetailId"));
                result.setVehicleDetailId(resultSet.getInt("VehicleDetailId"));                        
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
        return result;
    }

    @Override
    public VehicleCategoryReq Vehiclecategorybyid(int vcId) {
        VehicleCategoryReq result = new VehicleCategoryReq();
        try {
            String Quary = "select * from vehiclecategory where VehicleCategoryId` = '"+vcId+"' ";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Quary);
            while (resultSet.next()){
                result.setVehicleCategoryId(resultSet.getInt("VehicleCategoryId"));
                result.setVehicleCategoryName(resultSet.getString("VehicleCategoryName"));                       
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
        return result;
    }

    @Override
    public UserRegistrationReq getuserbyID(int uid) {
        UserRegistrationReq result = null;
       /* try {
            String SELECT_USER_BY_EMAIL = "select * from userdetail where UserDetailId = '"+uid+"'";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_USER_BY_EMAIL);
            while (resultSet.next()){
                result.setAddress(resultSet.getString("UserDetailId"));
                result.setEmailAddress(emailAddress);(resultSet.getString("UserType"));
                result.setFirstName(resultSet.getString("UserType"));
                result.setLastName(resultSet.getString("UserType"));
                result.setMobileNumber(resultSet.getString("UserType"));
                result.set(resultSet.getString("UserType"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {}
        }*/
        return result;
    }

}
