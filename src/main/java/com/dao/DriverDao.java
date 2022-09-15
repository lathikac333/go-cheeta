package com.dao;

import java.util.List;

import org.springframework.lang.Nullable;

import com.dto.response.TripDetails;
import com.dto.response.UserDriverDto;

public interface DriverDao {
    
    public List<TripDetails> TripRequst(String status, @Nullable int BranchId, @Nullable int driverId); 

    public List<TripDetails> DriverHistory(int driverId);

    public UserDriverDto DriverDetails(int uReq);
    
}
