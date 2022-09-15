package com.business;

import java.util.List;

import com.dto.response.TripDetails;
import com.dto.response.UserDTO;

public interface CustomerB {
    
    public UserDTO SelectedUserDtl(int userreq);

    public List<TripDetails> UserTripHistory(int userreq);

    public String UpdateUser(UserDTO user);
}
