package com.controller;

import com.dto.response.GeneralResponse;
import com.dto.response.UserDTO;

public interface CustomerCtrl {
    
    public GeneralResponse getSelectedUser(int userreq);

    public GeneralResponse getttripHistory(int userreq);

    public GeneralResponse onGoingtrip(int userreq);

    public String updateUserDetail(UserDTO user);
}
