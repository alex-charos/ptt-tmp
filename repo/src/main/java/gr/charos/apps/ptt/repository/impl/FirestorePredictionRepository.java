package gr.charos.apps.ptt.repository.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import gr.charos.apps.ptt.domain.Predictor;
import gr.charos.apps.ptt.domain.SquadPrediction;
import gr.charos.apps.ptt.repository.PredictionRepository;
import gr.charos.apps.ptt.repository.dto.SquadPredictionDTO;

public class FirestorePredictionRepository implements PredictionRepository {
	private static final String COLLECTION_NAME = "predictions";

	private final Logger LOGGER = LoggerFactory.getLogger(FirestorePredictionRepository.class);

	private final  Firestore db;
	

	public FirestorePredictionRepository(Firestore db) {
		this.db = db;
	}



	@Override
	public SquadPrediction createSquadPrediction(SquadPrediction squadPrediction) {
		try {
			
			var squaddto =  SquadPredictionDTO.fromSquadPrediction(squadPrediction);
			
			DocumentReference dr = this.db.collection(COLLECTION_NAME).add(squaddto).get();
			
			return dr.get().get().toObject(SquadPredictionDTO.class).toSquadPrediction();
		} catch (InterruptedException |  ExecutionException e) {
			throw new RuntimeException(e);
		}  
	}

	@Override
	public List<SquadPrediction> getSquadPredictions(Predictor predictor) {
		ApiFuture<QuerySnapshot> query = db.collection(COLLECTION_NAME)
								.whereEqualTo("predictor.id", predictor.id())
								.get();
		 try {
			  return query.get().toObjects(SquadPredictionDTO.class).stream()
					  .map(SquadPredictionDTO::toSquadPrediction).collect(Collectors.toList());
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.error("Error loading documents: ", e);
			throw new RuntimeException(e);
		}
		//return null;
	}

	@Override
	public void deleteSquadPrediction(SquadPrediction SquadPrediction) {
		// TODO Auto-generated method stub
		
	}

}
