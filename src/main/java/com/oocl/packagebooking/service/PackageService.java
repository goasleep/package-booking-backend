package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.reponsitory.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;


    public List<PackageOrder> findAll() {
        return packageRepository.findAll();
    }

    public void update(PackageOrder packageOrder) {
        packageRepository.save(packageOrder);
    }

    public void deleteById(int id) {
        packageRepository.deleteById(id);
    }

    public void save(PackageOrder packageOrder) {
        packageRepository.save(packageOrder);
    }
}
