package istic.taa.project.model;

import istic.taa.project.model.Location;
import istic.taa.project.model.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="favourite_location")
public class FavouriteLocation {
    @Id
    @GeneratedValue
    private long identifier;
    @OneToOne
    @JoinColumn(name="location_fk")
    private Location location;
    @OneToOne
    @JoinColumn(name="user_fk")
    private User user;

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

