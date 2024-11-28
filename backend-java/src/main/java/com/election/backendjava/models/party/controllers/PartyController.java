package com.election.backendjava.models.party.controllers;

import com.election.backendjava.entities.Party;
import com.election.backendjava.models.party.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/party")
public class PartyController {
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Party>> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return ResponseEntity.ok(parties);
    }

    @GetMapping("/party/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable(required = true) Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(partyService.getPartyById(id));
    }


}
