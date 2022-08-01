package gr.charos.apps.ptt.web.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gr.charos.apps.ptt.repository.PredictionRepository;
import gr.charos.apps.ptt.web.dto.SquadPredictionDTO;

@RestController
@Component
public class RestPredictionService {
	
	private PredictionRepository predictionRepository;
	
	
	
	public RestPredictionService(PredictionRepository predictionRepository) {
		this.predictionRepository = predictionRepository;
	}



	@PostMapping("/prediction")
	public void savePrediction(@RequestBody SquadPredictionDTO dto) {
		predictionRepository.createSquadPrediction(dto.toSquadPrediction());
	}

}
