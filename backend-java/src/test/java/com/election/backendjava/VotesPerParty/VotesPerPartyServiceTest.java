//package com.election.backendjava.VotesPerParty;
//
//import com.election.backendjava.entities.VotesPerParty;
//import com.election.backendjava.models.votesperparty.repositories.VotesPerPartyRepository;
//import com.election.backendjava.models.votesperparty.services.VotesPerPartyService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class VotesPerPartyServiceTest {
//
//    @Mock
//    private VotesPerPartyRepository votesPerPartyRepository;
//
//    @InjectMocks
//    private VotesPerPartyService votesPerPartyService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this); // Initialize the mocks
//    }
//
//    @Test
//    public void testGetVotesPerPartyByRegionCodeAndPartyId() {
//        // Arrange: Create mock objects
//        VotesPerParty vote = new VotesPerParty();
//        vote.setRegionCode("Region1");
//        vote.setPartyId(1);
//        vote.setValue(1000);
//
//        List<VotesPerParty> expectedVotes = List.of(vote);
//
//        // Mock the repository behavior
//        when(votesPerPartyRepository.findByRegionCodeAndPartyId("Region1", 1)).thenReturn(expectedVotes);
//
//        // Act: Call the service method
//        List<VotesPerParty> actualVotes = votesPerPartyService.getVotesPerPartyByRegionCodeAndPartyId("Region1", 1);
//        List<VotesPerParty> unknownVotes = votesPerPartyService.getVotesPerPartyByRegionCodeAndPartyId("Region2", 2);
//
//        // Assert: Check if the result is what you expected
//        assert(actualVotes.size() == 1); // There should be 1 item returned
//        assert(actualVotes.get(0).getRegionCode().equals("Region1")); // First region
//        assert(actualVotes.get(0).getPartyId() == 1); // First party ID
//        assert(actualVotes.get(0).getValue() == 1000); // First vote value
//
//        assert(unknownVotes.isEmpty()); // There should be 0 items returned
//    }
//}
