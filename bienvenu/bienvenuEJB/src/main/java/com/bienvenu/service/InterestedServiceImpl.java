package com.bienvenu.service;

import com.bienvenu.model.Interested;
import com.bienvenu.repository.InterestedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestedServiceImpl implements InterestedService {
    private final InterestedRepository interestedRepository;

    @Autowired
    public InterestedServiceImpl(InterestedRepository interestedRepository) {
        this.interestedRepository = interestedRepository;
    }

    @Override
    public Interested save(Interested interested) {
        return interestedRepository.save(interested);
    }

    @Override
    public boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId) {
        return interestedRepository.existsByUser_IdAndEvent_Id(userId, eventId);
    }

    @Override
    public List<Interested> findByUser_Id(Long userId) {
        return interestedRepository.findByUser_Id(userId);
    }
}
