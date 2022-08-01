package gr.charos.apps.ptt.web.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import gr.charos.apps.ptt.repository.PredictionRepository;
import gr.charos.apps.ptt.repository.impl.FirestorePredictionRepository;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public PredictionRepository predictionRepository() throws IOException{
		InputStream serviceAccount = BeanConfiguration.class.getClassLoader()
				.getResourceAsStream("firestore.json");
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);

		
		 return new FirestorePredictionRepository(FirestoreClient.getFirestore());
	}

}
