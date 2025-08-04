package com.bienvenu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bienvenu.model.Management;
import com.bienvenu.repository.ManagementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ManagementServiceImpl implements ManagementService{
    private final ManagementRepository managementRepository;

    @Autowired
    public ManagementServiceImpl(ManagementRepository managementRepository){
        this.managementRepository = managementRepository;
    }

    @Override
    public Management save(Management management) {
        return managementRepository.save(management);
    }

    @Override
    public List<Management> findAll() {
        return managementRepository.findAll();
    }
    
}
