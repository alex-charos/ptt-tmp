package gr.charos.apps.ptt.web.dto;

import java.util.List;

import gr.charos.apps.ptt.domain.HomeAway;
import gr.charos.apps.ptt.domain.Predictor;
import gr.charos.apps.ptt.domain.SquadPrediction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquadPredictionDTO {
	private String userId;
	private String fixtureId;
	private HomeAway side;
	private List<String> playerIds;
	
	public SquadPrediction toSquadPrediction() {
		return new SquadPrediction(new Predictor(userId, null), fixtureId, side, playerIds);
	}
	
}
