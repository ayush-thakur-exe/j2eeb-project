package com.bienvenu.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String place;

    private LocalDateTime datetime;

    private Float longitude;
    private Float latitude;

    @Column(name = "total_interest")
    private Long totalInterest;

    @OneToMany(mappedBy = "event")
    private Set<Management> managements;

    @OneToMany(mappedBy = "event")
    private Set<Interested> interests;

	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
	private Set<TicketLinks> ticketLinks;
    
    // Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Long getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(Long totalInterest) {
		this.totalInterest = totalInterest;
	}

	public Set<Management> getManagements() {
		return managements;
	}

	public void setManagements(Set<Management> managements) {
		this.managements = managements;
	}

	public Set<Interested> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interested> interests) {
		this.interests = interests;
	}

	public Set<TicketLinks> getTicketLinks() {
		return ticketLinks;
	}

	public void setTicketLinks(Set<TicketLinks> ticketLinks) {
		this.ticketLinks = ticketLinks;
	}
    
}
