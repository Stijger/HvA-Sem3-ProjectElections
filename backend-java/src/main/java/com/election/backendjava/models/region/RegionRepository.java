package com.election.backendjava.models.region;

import com.election.backendjava.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {

    @Query("SELECT new com.election.backendjava.models.region.RegionDTO(r.regionCode, r.name) " +
            "FROM Region r WHERE r.regionCode LIKE %:pattern%")
    List<RegionDTO> findRegionsWithPattern(@Param("pattern") String pattern);

    @Query("SELECT new com.election.backendjava.models.region.RegionDTO(r.regionCode, r.name) " +
            "FROM Region r WHERE r.parentRegionCode = :parentRegionCode")
    List<RegionDTO> findByParentRegionCode(@Param("parentRegionCode") String parentRegionCode);

    @Query("SELECT new com.election.backendjava.models.region.RegionDTO(r.regionCode, r.name) " +
            "FROM Region r WHERE r.greatParentRegionCode = :greatParentRegionCode")
    List<RegionDTO> findByGreatParentRegionCode(@Param("greatParentRegionCode") String greatParentRegionCode);

    @Query("SELECT new com.election.backendjava.models.region.RegionDTO(r.regionCode, r.name) " +
            "FROM Region r WHERE r.regionCode = :regionCode")
    RegionDTO findByRegionCode(@Param("regionCode") String regionCode);

}
