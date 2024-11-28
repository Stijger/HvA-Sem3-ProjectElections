package com.election.backendjava.models.votesperparty.controllers;

import com.election.backendjava.entities.VotesPerParty;
import com.election.backendjava.models.votesperparty.services.VotesPerPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for the VotesPerParty model
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/votesperparty")
public class VotesPerPartyController {
    private final VotesPerPartyService votesPerPartyService;

    @Autowired
    public VotesPerPartyController(VotesPerPartyService votesPerPartyService) {
        this.votesPerPartyService = votesPerPartyService;
    }

    /**
     * Get votes per party by region code and party ID
     * @param regionCode Region code
     * @param partyId Party ID
     * @return List of votes per party
     */
    @GetMapping("/partyvotesperregion")
    public List<VotesPerParty> getVotesPerPartyByRegionCodeAndPartyId(String regionCode, int partyId) {
        return votesPerPartyService.getVotesPerPartyByRegionCodeAndPartyId(regionCode, partyId);
    }

    /**
     * Get votes per party by region code
     * @param regionCode Region code
     * @return List of votes per party
     */
    @GetMapping("/votesperregion")
    public List<VotesPerParty> getVotesPerPartyByRegionCode(String regionCode) {
        return votesPerPartyService.getVotesPerPartyByRegionCode(regionCode);
    }

    @GetMapping("/allvotesperregion/{regionCode}")
    public List<VotesPerParty> getAllVotesPerPartyByRegionCode(@PathVariable String regionCode) {
        return votesPerPartyService.getAllVotesPerPartyByRegionCode(regionCode);
    }
}
