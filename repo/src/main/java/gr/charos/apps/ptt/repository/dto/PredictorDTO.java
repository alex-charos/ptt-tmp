package gr.charos.apps.ptt.repository.dto;

import gr.charos.apps.ptt.domain.Predictor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictorDTO {
	private String id;
	private String username;
	
	public Predictor toPredictor() {
		return new Predictor(id, username);
	}
	
	public static PredictorDTO fromPredictor(Predictor p) {
		return new PredictorDTO(p.id(),p.username());
	}

}
