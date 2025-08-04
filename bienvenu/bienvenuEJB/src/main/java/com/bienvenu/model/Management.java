package com.bienvenu.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Management")
@IdClass(ManagementId.class)
public class Management {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String role;

    // Getters and setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

class ManagementId implements Serializable {
    private Long user;
    private Long event;
}
