package com.dao;

import java.util.List;

import com.dto.request.*;
import com.dto.response.*;

public interface CustomerDao {
    
    public UserDTO SelectedUserDtl(UserReq userreq);

    public List<TripDetails> UserTripHistory(UserReq userreq);

    public String UpdateUser(UserDTO user);
}
