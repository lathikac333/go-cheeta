package com.controller.imp;

import com.business.TripBusiness;
import com.controller.TripController;
import com.business.impl.dao.TripDAO;
import com.dto.request.*;
import com.dto.response.BranchDetailRes;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TripControllerImpl implements TripController {

    @Autowired
    TripBusiness tripBusiness;
    TripDAO tripDAO;

    @Override
    @GetMapping("/tp")
    public String GetPage()
    {
        return "Hello Trip";
    }

    @Override
    @GetMapping("/trip/test")
    public String Testing()
    {
        return "Testing ";
    }

    @Override
    @PostMapping("/trip/create")
    public GeneralResponse createNewTrip(@RequestBody CreateTripReq createTripReq) {
        //.setUserDetailId(6);
        return tripBusiness.createNewTrip(createTripReq);
    }

    @Override
    @PostMapping("/trip/edit")
    public GeneralResponse editTrip(@RequestBody EditTripReq editTripReq) {
        return tripBusiness.editTrip(editTripReq);
    }

    @Override
    @PostMapping("/trip/assign/driver")
    public GeneralResponse assignDriverToTrip(@RequestBody TripDetailReq assignDriverReq) {
        return tripBusiness.assignDriverToTrip(assignDriverReq);
    }

    @Override
    @PostMapping("/trip/cancel")
    public GeneralResponse cancelTrip(@RequestBody TripDetailReq cancelTripReq) {
        return null; // tripBusiness.cancelTrip(cancelTripReq);
    }

    @Override
    @PostMapping("/trip/list")
    public GeneralResponse getTripList() {
        List<TripRes> list = tripBusiness.getTripList();
        return GeneralResponse.generateResponse(list,1000,"Success");
    }

    @Override
    @PostMapping("/trip/detail")
    public GeneralResponse getTripDetail(@RequestBody TripDetailReq tripDetailReq) {
        TripRes tripDetail = tripBusiness.getTripDetail(tripDetailReq);
        return GeneralResponse.generateResponse(tripDetail,1000,"Success");
    }

    @Override
    @GetMapping("/trip/location/list")
    public GeneralResponse getLocationList() {
        List<LocationRes> list = tripBusiness.getLocationList();
        return GeneralResponse.generateResponse(list,1000,"Success");
    }

    @Override
    @PostMapping("/trip/location/by/city")
    public GeneralResponse getLocationListByCity(@RequestBody GetLocationByCityReq getLocationByCityReq) {
        List<LocationRes> list = tripBusiness.getLocationListByCity(getLocationByCityReq);
        return GeneralResponse.generateResponse(list,1000,"Success");
    }

   /* @Override
    @PostMapping("/trip/branches")
    public GeneralResponse getBranchList(@RequestBody BranchDetailsReq BranchDetails); {
        List<BranchDetailsReq> list = tripBusiness.GetBranches(BranchDetails);
        return GeneralResponse.generateResponse(list,1000,"Success");
    }   */

    @Override
    @GetMapping("/trip/branches/list")
    public GeneralResponse  getBranchList() {
        List<BranchDetailRes> list = tripBusiness.GetBranches();
        return GeneralResponse.generateResponse(list,1000,"Success");
    }

    @Override
    @GetMapping("/branch/name")
    public GeneralResponse getBranchName() {
        String nn = tripDAO.getBarchName();
        return GeneralResponse.generateResponse(nn, 1000, "Success");
    }
}
