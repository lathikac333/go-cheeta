package com.business;

import com.dto.response.GeneralResponse;
import com.dto.response.UserDTO;

public interface CustomerB {
    
    public UserDTO SelectedUserDtl(int userreq);

    public GeneralResponse UserTripHistory(int userreq);

    public String UpdateUser(UserDTO user);
    public GeneralResponse ongoingTrip(int userid);
}
