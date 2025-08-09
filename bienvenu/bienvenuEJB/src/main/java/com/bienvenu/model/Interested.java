package com.bienvenu.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Interested")
@IdClass(InterestedId.class)
public class Interested {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    

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

}
