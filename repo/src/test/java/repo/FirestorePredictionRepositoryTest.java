package repo;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import gr.charos.apps.ptt.domain.Club;
import gr.charos.apps.ptt.domain.FootballFixture;
import gr.charos.apps.ptt.domain.FootballMatchdaySquad;
import gr.charos.apps.ptt.domain.HomeAway;
import gr.charos.apps.ptt.domain.Predictor;
import gr.charos.apps.ptt.domain.SquadPrediction;
import gr.charos.apps.ptt.repository.impl.FirestorePredictionRepository;

public class FirestorePredictionRepositoryTest {

	
	@Test
	public void testSave() throws IOException {
		InputStream serviceAccount = FirestorePredictionRepositoryTest.class.getClassLoader()
				.getResourceAsStream("firestore.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);

		
;
		 FirestorePredictionRepository repo = new FirestorePredictionRepository(FirestoreClient.getFirestore());
		 FootballMatchdaySquad home = new FootballMatchdaySquad( new Club("LFC", "Liverpool"),Collections.emptyList());
		 FootballMatchdaySquad away = new FootballMatchdaySquad( new Club("EFC", "Everton"),Collections.emptyList());
		 FootballMatchdaySquad predicted = new FootballMatchdaySquad( new Club("WUT", "wrong"),Collections.emptyList());
		 
		 FootballFixture f = new FootballFixture(ZonedDateTime.now(), home, away);
		 
		 SquadPrediction sp = new SquadPrediction(
				 						new Predictor("12", "testpredictor"), 
				 						UUID.randomUUID().toString(), 
				 						HomeAway.AWAY,
				 						List.of("1", "2", "4"));
		 
		 
		 repo.createSquadPrediction(sp);
		 repo.getSquadPredictions(new Predictor("1","test"));

	}
}
