package com.bienvenu.service;

import java.util.List;

import com.bienvenu.model.Management;

public interface ManagementService {
    Management save(Management management);
    List<Management> findAll();
    List<Management> findByUser_Id(Long userId);
}
