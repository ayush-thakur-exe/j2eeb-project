package com.bienvenu.model;

import java.io.Serializable;
import java.util.Objects;

public class InterestedId implements Serializable {
    private Long user;
    private Long event;

    public InterestedId() {}

    public InterestedId(Long user, Long event) {
        this.user = user;
        this.event = event;
    }

    public Long getUser() { return user; }
    public Long getEvent() { return event; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InterestedId)) return false;
        InterestedId that = (InterestedId) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, event);
    }
}
