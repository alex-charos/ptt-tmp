package gr.charos.apps.ptt.repository;

import java.util.List;

import gr.charos.apps.ptt.domain.Predictor;
import gr.charos.apps.ptt.domain.SquadPrediction;

public interface PredictionRepository {

	SquadPrediction createSquadPrediction(SquadPrediction SquadPrediction);
	List<SquadPrediction> getSquadPredictions(Predictor predictor);
	//SquadPrediction updateSquadPrediction(SquadPrediction SquadPrediction);
	void deleteSquadPrediction(SquadPrediction SquadPrediction);

	
}
