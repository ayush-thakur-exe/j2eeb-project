package com.bienvenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bienvenu.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findByPlace(String place);
    @Query("select e from Event e left join fetch e.ticketLinks where e.id = :id")
    Optional<Event> findByIdWithLinks(@Param("id") Long id);
    @Query("select e from Event e where lower(e.title) like lower(concat('%', :q, '%')) or lower(e.description) like lower(concat('%', :q, '%')) or lower(e.place) like lower(concat('%', :q, '%'))")
    List<Event> search(@Param("q") String q);
}
