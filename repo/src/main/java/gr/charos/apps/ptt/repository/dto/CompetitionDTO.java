package gr.charos.apps.ptt.repository.dto;

import gr.charos.apps.ptt.domain.Competition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDTO {
	private String id;
	private String name;
	

	public Competition toCompetition() {
		return new Competition(id, name);
	}
	
	public static CompetitionDTO fromCompetition(Competition c) {
		return new CompetitionDTO(c.id(), c.name());
	}
}
