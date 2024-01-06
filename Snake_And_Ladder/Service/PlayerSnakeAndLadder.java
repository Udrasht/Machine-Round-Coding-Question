package Service;

import java.util.*;

import Model.Entities;
import Model.PairPosition;
import Model.Dice;

public class PlayerSnakeAndLadder {
    HashMap<String, PairPosition> PlayerHistory;
    HashMap<String, Integer> PlayerLatestPosition;
    Entities entities;
    Dice dice;

   public PlayerSnakeAndLadder(int N) {
        PlayerHistory = new HashMap<>();
        PlayerLatestPosition = new HashMap<>();
        entities = Entities.getInstance();
        dice = new Dice(N);

    }

    private void initilizePlayersStartValue() {
        for (int i = 0; i < entities.getPlayer().size(); i++) {
            PlayerLatestPosition.put(entities.getPlayer().get(i), 0);
           
            

        }
    }

    public String PlayGame() {
        initilizePlayersStartValue();
        int i = -1;
        do {
            i++; // i th Players playing
            if (i >= entities.getPlayer().size()) {
                i = 0;
            }
            String str=""; // To print output
            String playeName = entities.getPlayer().get(i);
            str=str+playeName;
            int diceNumber = dice.getNumberOfDice();
            int endPosition = PlayerLatestPosition.get(playeName) + diceNumber;
            String sl = "";
            if (endPosition<=100) {
                str=str+" rolled a "+diceNumber;
                str=str+" and moved from "+PlayerLatestPosition.get(playeName);
                if (entities.getSnake().get(endPosition) != null) {
                    // Captures snake
                    sl = " after Snake dinner";
                    PlayerLatestPosition.put(playeName, entities.getSnake().get(endPosition));
                } else {
                    if (entities.getLadder().get(endPosition) != null) {
                        // up ladder
                        sl = " after Ladder ride ";
                        PlayerLatestPosition.put(playeName, entities.getLadder().get(endPosition));
                    } else {
                        PlayerLatestPosition.put(playeName, endPosition);
                    }
                }
                str=str+" to "+PlayerLatestPosition.get(playeName);
                str=str+sl;
            }
            else{
                str=str+" rolled a "+diceNumber+" and not move";
            }
            System.out.println(str);
        } while (!isPlayerWon(entities.getPlayer().get(i)));


        return entities.getPlayer().get(i);

    }
    private boolean isPlayerWon(String player){
        return PlayerLatestPosition.get(player) == 100;
    }

}
