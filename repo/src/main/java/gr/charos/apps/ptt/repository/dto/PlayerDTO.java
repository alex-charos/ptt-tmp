package gr.charos.apps.ptt.repository.dto;

import gr.charos.apps.ptt.domain.Player;
import gr.charos.apps.ptt.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
	private String id;
	private String firstname;
	private String lastname;
	private Position position;

	public Player toPlayer() {
		return new Player(id, firstname, lastname, position);
	}

	public static PlayerDTO fromPlayer(Player p)  {
		return new PlayerDTO(p.id(), p.firstname(), p.lastname(), p.position());
	}
	
	
}
