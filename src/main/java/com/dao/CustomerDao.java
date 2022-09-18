package com.business.impl.dao;

import java.util.List;

import com.dto.response.*;

public interface CustomerDao {
    
    public UserDTO SelectedUserDtl(int userreq);

    public List<TripDetails> UserTripHistory(int userreq);

    public String UpdateUser(UserDTO user);
}
