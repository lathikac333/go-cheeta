package com.business.impl;

import com.business.TripBusiness;
import com.business.impl.dao.TripDAO;
import com.dto.request.*;
import com.dto.response.BranchDetailRes;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripBusinessImpl implements TripBusiness {
    @Autowired
    TripDAO tripDAO;

    @Override
    public GeneralResponse createNewTrip(CreateTripReq createTripReq) {
        if(validatetrip(createTripReq)){
            return tripDAO.createNewTrip(createTripReq);
        }
        else {
            return new GeneralResponse(null,1001,"Please update the mandatory values...!");
        }        
    }

    @Override
    public GeneralResponse editTrip(EditTripReq editTripReq) {
        return null;// tripDAO.editTrip(editTripReq);
    }

    @Override
    public GeneralResponse assignDriverToTrip(TripDetailReq TripDetailReq) {
        return tripDAO.assignDriverToTrip(TripDetailReq);
    }

    @Override
    public GeneralResponse cancelTrip(TripDetailReq TripDetailReq, String sts) {
        return tripDAO.editTrip(TripDetailReq, sts);
    }

    @Override
    public List<TripRes> getTripList() {
        return tripDAO.getTripList();
    }

    @Override
    public TripRes getTripDetail(TripDetailReq tripDetailReq) {
        return tripDAO.getTripDetail(tripDetailReq);
    }

    @Override
    public List<LocationRes> getLocationList() {
        return tripDAO.getLocationList();
    }

    @Override
    public List<LocationRes> getLocationListByCity(GetLocationByCityReq getLocationByCityReq) {
        return tripDAO.getLocationListByCity(getLocationByCityReq);
    }

    @Override
    public List<BranchDetailRes> GetBranches( ) {
        return tripDAO.getBranchDetail();
    }

    private boolean validatetrip(CreateTripReq createTripReq)
    {
        boolean bool = false;
        if(createTripReq.getBranchId() > 0){
            bool = true;
        }
        if(createTripReq.getSourceLocationId() > 0){
            bool = true;
        }
        if(createTripReq.getDestinationLocationId() > 0){
            bool = true;
        }
        if(createTripReq.getTravelDateTime() != null && !createTripReq.getTravelDateTime().equals("")){
            bool = true;
        }
        if(createTripReq.getUserDetailId() > 0){
            bool = true;
        }
        return bool;
    }
}
