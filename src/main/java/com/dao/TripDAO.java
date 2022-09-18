package com.business.impl.dao;

import com.dto.request.*;
import com.dto.response.GeneralResponse;
import com.dto.response.LocationRes;
import com.dto.response.TripRes;
import com.dto.response.BranchDetailRes;

import java.util.List;

public interface TripDAO {
    /**
     * createNewTrip
     * @param createTripReq
     * @return
     */
    GeneralResponse createNewTrip(CreateTripReq createTripReq);

    /**
     * assignDriverToTrip
     * @param assignDriverReq
     * @return
     */
    GeneralResponse assignDriverToTrip(TripDetailReq TripDetailReq);

    /**
     * cancelTrip
     * @param cancelTripReq
     * @return
     */
    GeneralResponse editTrip(TripDetailReq TripDetailReq, String Status);

    /**
     * getTripList
     * @return
     */
    List<TripRes> getTripList();

    /**
     * getTripDetail
     * @param tripDetailReq
     * @return
     */
    TripRes getTripDetail(TripDetailReq tripDetailReq);

    /**
     * getLocationList
     * @return
     */
    List<LocationRes> getLocationList();

    /**
     * getLocationListByCity
     * @param getLocationByCityReq
     * @return
     */
    List<LocationRes> getLocationListByCity(GetLocationByCityReq getLocationByCityReq);


    /**
     * @return
     */
    List<BranchDetailRes> getBranchDetail();

    String getBarchName();


}
