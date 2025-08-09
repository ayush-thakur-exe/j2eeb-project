package com.bienvenu.repository;

import com.bienvenu.model.Event;
import com.bienvenu.model.Interested;
import com.bienvenu.model.InterestedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestedRepository extends JpaRepository<Interested, InterestedId> {
    boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);
    List<Interested> findByUser_Id(Long userId);
}
