package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Entity representing a single hotel.
 * <p>
 * Every hotel has collection of rooms, which are available for booking.
 * Hotel may have his own name.
 *
 * @see Room
 * @author Ivo Hradek
 */
@Entity
public class Hotel {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "hotel")
    private Collection<Room> rooms = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Collection<Room> getRooms() {
        return Collections.unmodifiableCollection(rooms);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;

        final Hotel hotel = (Hotel) o;

        return hotel.getId().equals(getId()) &&
               hotel.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        int result;
        result = 31 + ((null == getName()) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
