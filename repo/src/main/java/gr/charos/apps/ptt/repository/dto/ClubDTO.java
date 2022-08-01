package gr.charos.apps.ptt.repository.dto;

import gr.charos.apps.ptt.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDTO {
	private String id;
	private String name;
	
	public Club toClub() {
		return new Club(id, name);
	}
	
	public static ClubDTO fromClub(Club c) {
		return new ClubDTO(c.id(), c.name());
	}

}
