package gr.charos.apps.ptt.repository.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gr.charos.apps.ptt.domain.FootballMatchdaySquad;
import gr.charos.apps.ptt.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballMatchdaySquadDTO {
	private ClubDTO club;
	private List<PlayerDTO> squad;
	
	public FootballMatchdaySquad toFootballMatchdaySquad() {
		List<Player> players = new ArrayList<>();
		if (squad !=null && !squad.isEmpty() ) {
			players = squad.stream().map(PlayerDTO::toPlayer).collect(Collectors.toList());
		}
		return new FootballMatchdaySquad(club.toClub(), players);
	}
	
	public static FootballMatchdaySquadDTO fromFootballMatchdaySquad(FootballMatchdaySquad squad) {
		List<PlayerDTO> players = new ArrayList<>();
		if (squad.squad() !=null && !squad.squad().isEmpty()) {
			players =squad.squad().stream().map(PlayerDTO::fromPlayer).collect(Collectors.toList());
		}
		return new FootballMatchdaySquadDTO(ClubDTO.fromClub(squad.club()), players);
	}

}
