package gr.charos.apps.ptt.domain;

import java.util.List;

public record SquadPrediction(Predictor predictor, String fixtureId, HomeAway side, List<String> playerIds) {

}
