package com.bienvenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bienvenu.model.Management;

import java.util.List;

@Repository
public interface ManagementRepository extends JpaRepository<Management, Long>{
    List<Management> findByUser_Id(Long userId);
}
