package com.election.backendjava.models.region;

import com.election.backendjava.entities.Region;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegionDTO>> getAllRegions() {
        List<Region> regions = regionService.getAllRegions();

        // Map Region naar RegionDTO
        List<RegionDTO> regionDTOs = regions.stream()
                .map(region -> new RegionDTO(region.getRegionCode(), region.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(regionDTOs);
    }

    @GetMapping("/province")
    public List<RegionDTO> getRegionsWithP() {
        return regionService.getRegionsContainingP();
    }

    @GetMapping("/parent/{parentRegionCode}")
    public List<RegionDTO> getRegionsByParentRegionCode(@PathVariable String parentRegionCode) {
        return regionService.getRegionsByParentCode(parentRegionCode);
    }

    @GetMapping("/regionCode/{regionCode}")
    public RegionDTO getRegionByRegionCode(@PathVariable String regionCode) {
        return regionService.getRegionByRegionCode(regionCode);
    }

    @GetMapping("/greatParent/{greatParentRegionCode}")
    public List<RegionDTO> getRegionsByGreatParentRegionCode(@PathVariable String greatParentRegionCode) {
        return regionService.getRegionsByGreatParentRegionCode(greatParentRegionCode);
    }
}
