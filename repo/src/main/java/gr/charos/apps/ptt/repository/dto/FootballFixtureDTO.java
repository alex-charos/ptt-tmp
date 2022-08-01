package gr.charos.apps.ptt.repository.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import gr.charos.apps.ptt.domain.FootballFixture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballFixtureDTO {
	
	public static final String DATE_FORMAT = "MM/dd/yyyy - HH:mm:ss Z";
	
	private String date;
	private FootballMatchdaySquadDTO home;
	private FootballMatchdaySquadDTO away;
	
	public FootballFixture toFootballFixtures() {
		return new FootballFixture(ZonedDateTime.parse(date, DateTimeFormatter.ofPattern(FootballFixtureDTO.DATE_FORMAT)), 
				home.toFootballMatchdaySquad(), away.toFootballMatchdaySquad());
	}
	
	public static FootballFixtureDTO fromFootballFixture(FootballFixture fixture) {
		return new FootballFixtureDTO(
					fixture.date().format(DateTimeFormatter.ofPattern(FootballFixtureDTO.DATE_FORMAT)),
					FootballMatchdaySquadDTO.fromFootballMatchdaySquad(fixture.home()), 
					FootballMatchdaySquadDTO.fromFootballMatchdaySquad(fixture.away())
					);
	}

}
