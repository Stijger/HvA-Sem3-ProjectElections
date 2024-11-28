package com.election.backendjava.models.party.repositories;

import com.election.backendjava.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartyRepository extends JpaRepository<Party, Integer> {

}
