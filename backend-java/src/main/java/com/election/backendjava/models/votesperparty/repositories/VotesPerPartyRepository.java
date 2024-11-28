package com.election.backendjava.models.votesperparty.repositories;

import com.election.backendjava.entities.VotesPerParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the VotesPerParty model
 */
@Repository
public interface VotesPerPartyRepository extends JpaRepository<VotesPerParty, Integer> {
    List<VotesPerParty> findByRegionCodeAndPartyId(String regionCode, int partyId);

    List<VotesPerParty> findByRegionCode(String regionCode);

    @Query("SELECT v FROM VotesPerParty v WHERE v.regionCode = :regionCode")
    List<VotesPerParty> findAllByRegionCode(@Param("regionCode") String regionCode);
}
