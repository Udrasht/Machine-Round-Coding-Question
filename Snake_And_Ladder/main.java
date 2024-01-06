

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Model.Entities;
import Service.PlayerSnakeAndLadder;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Entities entities=Entities.getInstance();

        int noOfSnakes = scan.nextInt();
        while(noOfSnakes>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.setSnake(startPosition, endPosition);
            noOfSnakes--;
        }
        int noOfLadders = scan.nextInt();
        while(noOfLadders>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.setLadder(startPosition, endPosition);
            noOfLadders--;
        }
        int noOfPlayers = scan.nextInt();
     
        int i=0;
        while(noOfPlayers>0){
            String player = scan.next();
           
            entities.setPlayers(player,i++);
            noOfPlayers--;
        }
  

       
        PlayerSnakeAndLadder playSnakeAndLadder = new PlayerSnakeAndLadder(6);
        System.out.println(playSnakeAndLadder.PlayGame()+" wins the game");
    }
}