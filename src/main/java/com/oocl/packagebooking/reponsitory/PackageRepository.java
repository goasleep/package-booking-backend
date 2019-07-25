package com.oocl.packagebooking.reponsitory;

import com.oocl.packagebooking.entity.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<PackageOrder,Integer> {
}
