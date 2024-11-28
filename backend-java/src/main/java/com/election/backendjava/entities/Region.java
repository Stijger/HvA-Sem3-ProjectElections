package com.election.backendjava.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "regionCode")
    private String regionCode;

    @Column(name = "parentRegionCode")
    private String parentRegionCode;

    @Column(name = "greatParentRegionCode")
    private String greatParentRegionCode;

    @Column(name = "name")
    private String name;

    //getters en setters
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getParentRegionCode() {
        return parentRegionCode;
    }

    public void setParentRegionCode(String parentRegionCode) {
        this.parentRegionCode = parentRegionCode;
    }

    public String getGreatParentRegionCode() {
        return greatParentRegionCode;
    }

    public void setGreatParentRegionCode(String greatParentRegionCode) {
        this.greatParentRegionCode = greatParentRegionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
