package com.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.AdminCtrl;
import com.business.AdminBusiness;
import com.dto.response.GeneralResponse;

@RestController
@CrossOrigin("*")
public class AdminCtrlImpl implements AdminCtrl {

    @Autowired
    AdminBusiness AdminBusiness;

    @Override
    @GetMapping("/admin/view/viewCurentTrips")
    public GeneralResponse viewCurentTrips() {
        return AdminBusiness.viewCurentTrips();
    }

    @Override
    @GetMapping("/admin/view/driverlist")
    public GeneralResponse driverlist() {
        return AdminBusiness.driverlist();
    }

    @Override
    @GetMapping("/admin/view/vehicleList")
    public GeneralResponse vehicleList() {
        return AdminBusiness.vehicleList();
    }

    @Override
    @GetMapping("/admin/view/summary")
    public GeneralResponse summary() {
        return AdminBusiness.summary();
    }

    @Override
    @GetMapping("/admin/view/vehicleCategorylist")
    public GeneralResponse vehicleCategorylist() {
        return AdminBusiness.vehicleCategorylist();
    }

    
}
