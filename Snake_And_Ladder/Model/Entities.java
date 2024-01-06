package Model;
import java.util.*;

public class Entities {
     HashMap<Integer,Integer> snakes;
     HashMap<Integer,Integer> ladder;
     HashMap<Integer,String> players;
   static Entities instance=null;
    Entities(){
        snakes=new HashMap<>();
        ladder=new HashMap<>();
        players=new HashMap<>();
    }
    public void setSnake(int startPosition,int endPosition){
        snakes.put(startPosition,endPosition);
    }
    
    public HashMap<Integer,Integer> getSnake(){
        return snakes;
    }
    public void setLadder(int startPosition,int endPosition){
        ladder.put(startPosition,endPosition);
    }
    
    public HashMap<Integer,Integer> getLadder(){
        return ladder;
    }

    public void setPlayers(String playerName,int indx){
        players.put(indx,playerName);
    }
    
    public HashMap<Integer,String> getPlayer(){
        return players;
    }
    public static Entities getInstance(){
        if( instance == null){
           instance = new Entities();
        }
        return instance;
    }


}
