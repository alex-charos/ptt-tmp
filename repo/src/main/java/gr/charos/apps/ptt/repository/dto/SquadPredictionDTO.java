package gr.charos.apps.ptt.repository.dto;

import java.util.List;

import gr.charos.apps.ptt.domain.HomeAway;
import gr.charos.apps.ptt.domain.SquadPrediction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadPredictionDTO {
	
	private PredictorDTO predictor;
	private String fixtureId;
	private HomeAway side;
	private List<String> playerIds;
	
	public SquadPrediction toSquadPrediction() {
		return new SquadPrediction(predictor.toPredictor(), fixtureId, side, playerIds);
//		return new SquadPrediction(predictor.toPredictor(), fixture.toFootballFixtures(), predictedSquad.toFootballMatchdaySquad());
	}
	
	public static SquadPredictionDTO fromSquadPrediction(SquadPrediction squadPrediction) {
//		return new SquadPredictionDTO(
//						PredictorDTO.fromPredictor(squadPrediction.predictor()), 
//						FootballFixtureDTO.fromFootballFixture(squadPrediction.fixture()), 
//						FootballMatchdaySquadDTO.fromFootballMatchdaySquad(squadPrediction.predictedSquad()) );
		return new SquadPredictionDTO(
						PredictorDTO.fromPredictor(squadPrediction.predictor()), 
						squadPrediction.fixtureId(),
						squadPrediction.side(),
						squadPrediction.playerIds());
				
	}

}
