package com.controller;

import com.dto.request.*;
import com.dto.response.GeneralResponse;

public interface TripController {
    
    /**
     * createNewTrip
     * @return
     */
    public String GetPage();

    public String Testing();
    /**
     * createNewTrip
     * @param createTripReq
     * @return
     */
    public GeneralResponse createNewTrip(CreateTripReq createTripReq);

    /**
     * editTrip
     * @param editTripReq
     * @return
     */
    public GeneralResponse editTrip(EditTripReq editTripReq);

    /**
     * assignDriverToTrip
     * @param assignDriverReq
     * @return
     */
    public GeneralResponse assignDriverToTrip(TripDetailReq assignDriverReq);

    /**
     * cancelTrip
     * @param cancelTripReq
     * @return
     */
    public GeneralResponse cancelTrip(TripDetailReq cancelTripReq);

    /**
     * getTripList
     * @return
     */
    public GeneralResponse getTripList();

    /**
     * getTripDetail
     * @param tripDetailReq
     * @return
     */
    public GeneralResponse getTripDetail(TripDetailReq tripDetailReq);

    /**
     * getLocationList
     * @return
     */
    public GeneralResponse getLocationList();

    /**
     * getLocationListByCity
     * @param getLocationByCityReq
     * @return
     */
    public GeneralResponse getLocationListByCity(GetLocationByCityReq getLocationByCityReq);

    /**
     * getBranchList
     * @return
     */
    public GeneralResponse getBranchList();

    public GeneralResponse getBranchName();
}
