package com.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.AdminBusiness;
import com.business.impl.dao.AdminViewDao;
import com.business.impl.dao.CommonDao;
import com.business.impl.dao.CustomerDao;
import com.dto.DBdto.Driverdto;
import com.dto.DBdto.summarycount;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.GeneralResponse;
import com.dto.response.TripDetails;
import com.dto.response.VehicleDetailRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AdminBusinessImpl implements AdminBusiness{

    @Autowired
    private AdminViewDao AdminViewDao;
    @Autowired
    private CommonDao CommonDao;
    @Autowired
    private CustomerDao customerDao;
    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public GeneralResponse viewCurentTrips() {
        List<TripDetails> TripDet = AdminViewDao.viewCurentTrips();
        for (TripDetails tripDetails : TripDet) {            
            tripDetails.setBranch(CommonDao.getBranchbyid(tripDetails.getBranchId()).getBranchName());
            tripDetails.setDestinationLocation(CommonDao.getLocationbyid(tripDetails.getDestinationLocationId()));
            tripDetails.setSourceLocation(CommonDao.getLocationbyid(tripDetails.getSourceLocationId()));
            tripDetails.setUser(customerDao.SelectedUserDtl(tripDetails.getUserDetailid()));

            Driverdto d = CommonDao.getDriverbyid(tripDetails.getDriverId());
            tripDetails.setDriver(customerDao.SelectedUserDtl(d.getUserDetailId()));
            //todo write to get driveruser details
        }
            String jsonString = "";
            try {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(TripDet);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("viewCurentTrips");
            System.out.println(jsonString);
        return GeneralResponse.generateResponse(TripDet,1000,"Success");
    }

    @Override
    public GeneralResponse driverlist() {
        List<Driverdto> driverl =   AdminViewDao.driverlist();
        for (Driverdto Driver : driverl) {            
            Driver.setBranch(CommonDao.getBranchbyid(Driver.getBranchId()));
            Driver.setUserDetail(customerDao.SelectedUserDtl(Driver.getUserDetailId()));
            Driver.setVehicleDetail(CommonDao.getVehiclebyid(Driver.getVehicleDetailId()));
        }
        String jsonString = "";
            try {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(driverl);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("driverlist");
            System.out.println(jsonString);
        return GeneralResponse.generateResponse(driverl,1000,"Success");
    }

    @Override
    public GeneralResponse vehicleList() {
        List<VehicleDetailRes> VehicleDetail =  AdminViewDao.vehicleList();
        for (VehicleDetailRes Vehicle : VehicleDetail) {            
            Vehicle.setVehicleCategoryName(CommonDao.Vehiclecategorybyid(Vehicle.getVehicleCategoryid()).getVehicleCategoryName());
        }
        String jsonString = "";
            try {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(VehicleDetail);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("vehicleList");
            System.out.println(jsonString);
        return GeneralResponse.generateResponse(VehicleDetail,1000,"Success");
    }

    @Override
    public GeneralResponse summary() {
        summarycount cunt =  AdminViewDao.summary();
        String jsonString = "";
            try {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cunt);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("summary");
            System.out.println(jsonString);
        return GeneralResponse.generateResponse(cunt,1000,"Success");
    }

    @Override
    public GeneralResponse vehicleCategorylist() {
        List<VehicleCategoryReq> vehicleCategory =  AdminViewDao.vehicleCategorylist();
        String jsonString = "";
            try {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicleCategory);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("vehicleCategorylist");
            System.out.println(jsonString);
        return GeneralResponse.generateResponse(vehicleCategory,1000,"Success");
    }
    
}
