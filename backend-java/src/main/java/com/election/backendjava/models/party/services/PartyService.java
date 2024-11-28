package com.election.backendjava.models.party.services;

import com.election.backendjava.entities.Party;
import com.election.backendjava.models.party.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    private final PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    public Party getPartyById(int id) {
        return partyRepository.findById(id).orElse(null);
    }

}
