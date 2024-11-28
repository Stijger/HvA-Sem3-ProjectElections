package com.election.backendjava.entities;

import jakarta.persistence.*;
import jakarta.servlet.http.Part;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "partyId", referencedColumnName = "id")
    private Party partyId;

    @Column(name = "initials")
    private String initials;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private String gender;

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Party getPartyId() {
        return partyId;
    }

    public void setPartyId(Party partyId) {
        this.partyId = partyId;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
