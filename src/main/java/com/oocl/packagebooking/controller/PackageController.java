package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController {

    @Autowired
    PackageService packageService;


    @GetMapping("/package")
    public List<PackageOrder> findAllPackage(){
        return packageService.findAll();
    }
}
