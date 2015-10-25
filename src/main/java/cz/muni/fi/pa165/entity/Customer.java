package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Entity representing a customer.
 * <p>
 * Every customer has forename and surname. Customer is able to make one or
 * more bookings in the hotels.
 *
 * @see Booking
 * @author Ivo Hradek
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String forename;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "customer")
    private Collection<Booking> bookings = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Collection<Booking> getBookings() {
        return Collections.unmodifiableCollection(bookings);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}