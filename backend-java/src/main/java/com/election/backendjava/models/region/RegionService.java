package com.election.backendjava.models.region;

import com.election.backendjava.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public List<RegionDTO> getRegionsContainingP() {
        return regionRepository.findRegionsWithPattern("p");
    }

    public List<RegionDTO> getRegionsByParentCode(String parentRegionCode) {
        return regionRepository.findByParentRegionCode(parentRegionCode);
    }

    public List<RegionDTO> getRegionsByGreatParentRegionCode(String greatParentRegionCode) {
        return regionRepository.findByGreatParentRegionCode(greatParentRegionCode);
    }

    public RegionDTO getRegionByRegionCode(String regionCode) {
        return regionRepository.findByRegionCode(regionCode);
    }
}
