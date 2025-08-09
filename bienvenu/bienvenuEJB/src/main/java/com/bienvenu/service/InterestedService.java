package com.bienvenu.service;

import com.bienvenu.model.Interested;

import java.util.List;

public interface InterestedService {
    Interested save(Interested interested);
    boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);
    List<Interested> findByUser_Id(Long userId);
}
