package com.election.backendjava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity for the VotesPerParty model
 */
@Entity
@Table(name = "votesperparty")
public class VotesPerParty {

    //Properties
    @Column(name = "regionCode")
    private String regionCode;

    @Id
    @Column(name = "partyId")
    private int partyId;

    @Column(name = "value")
    private int value;

    //Getters and Setters
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
