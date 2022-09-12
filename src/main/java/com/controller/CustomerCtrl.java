package com.controller;

import com.dto.request.UserReq;
import com.dto.response.*;;

public interface CustomerCtrl {
    
    public GeneralResponse getSelectedUser(UserReq userreq);

    public GeneralResponse getttripHistory(UserReq userreq);

    public GeneralResponse onGoingtrip(UserReq userreq);

    public String updateUserDetail(UserDTO user);
}
