package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PackageController {

    @Autowired
    PackageService packageService;


    @GetMapping("/packages")
    public List<PackageOrder> findAllPackage(){
        return packageService.findAll();
    }

    @PutMapping("/packages/{id}")
    public void updatePackage(@PathVariable int id,@RequestBody PackageOrder packageOrder){
        packageService.update(packageOrder);
    }

    @DeleteMapping("/packages/{id}")
    public void deletePackage(@PathVariable int id){
        packageService.deleteById(id);
    }

    @PostMapping("/packages")
    public void addPackage(@RequestBody PackageOrder packageOrder){
        packageService.save(packageOrder);
    }
}
