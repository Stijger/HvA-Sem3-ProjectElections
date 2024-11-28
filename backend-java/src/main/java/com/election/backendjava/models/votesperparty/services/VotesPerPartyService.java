package com.election.backendjava.models.votesperparty.services;

import com.election.backendjava.entities.VotesPerParty;
import com.election.backendjava.models.votesperparty.repositories.VotesPerPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for the VotesPerParty model
 */
@Service
public class VotesPerPartyService {
    @Autowired
    private VotesPerPartyRepository votesPerPartyRepository;

    /**
     * Get votes per party by region code and party ID
     * @param regionCode Region code
     * @param partyId Party ID
     * @return List of votes per party
     */
    public List<VotesPerParty> getVotesPerPartyByRegionCodeAndPartyId(String regionCode, int partyId) {
        return votesPerPartyRepository.findByRegionCodeAndPartyId(regionCode, partyId);
    }

    /**
     * Get votes per party by region code
     * @param regionCode Region code
     * @return List of votes per party
     */
    public List<VotesPerParty> getVotesPerPartyByRegionCode(String regionCode) {
        return votesPerPartyRepository.findByRegionCode(regionCode);
    }

    public List<VotesPerParty> getAllVotesPerPartyByRegionCode(String regionCode) {
        return votesPerPartyRepository.findAllByRegionCode(regionCode);
    }
}
