package com.election.backendjava.dto;

public class VotingResultDTO {

    private String regionCode;
    private int partyId;
    private int value;

    // Constructor
    public VotingResultDTO(String regionCode, int partyId, int value) {
        this.regionCode = regionCode;
        this.partyId = partyId;
        this.value = value;
    }

    // Getters
    public String getRegionCode() {
        return regionCode;
    }

    public int getPartyId() {
        return partyId;
    }

    public int getValue() {
        return value;
    }

    // Setters
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
