package Model;

import java.util.Random;

public class Dice{
    private int noOfDies;
    Random rand;
    public Dice(int noOfDies){
        this.noOfDies=noOfDies;
        rand=new Random();    

    }
    public int getNumberOfDice(){
        return rand.nextInt(noOfDies-1)+1;
    }

}
