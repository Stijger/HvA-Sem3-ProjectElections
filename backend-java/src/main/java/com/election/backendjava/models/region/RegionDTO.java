package com.election.backendjava.models.region;

public class RegionDTO {

    private String regionCode;
    private String name;

    // Constructor
    public RegionDTO(String regionCode, String name) {
        this.regionCode = regionCode;
        this.name = name;
    }

    // Getters en Setters
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
