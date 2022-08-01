package gr.charos.apps.ptt.repository;

import java.util.List;

import gr.charos.apps.ptt.domain.Club;
import gr.charos.apps.ptt.domain.Fixture;

public interface FixtureService {
	
	
	/*
	Club createClub(Club club);
	Club updateClub(Club club);
	void deleteClub(Club club);

	Player createPlayer(Player player);
	Player updatePlayer(Player player);
	void deletePlayer(Player player);
	
	*/
	
	Fixture createFixture(Fixture fixture);
	List<Fixture> getFixtures(Club club);// TODO: Pageable
	void deleteFixture(Fixture fixture);
	Fixture updateFixture(Fixture fixture);
	
	

}
