import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CharacterStats{
   
   public int[] stats = new int [5]; //tried to make it an array of SimpleIntegerProperty 's
   String item;
   
   //constructor
   public CharacterStats(int strength, int cunning, int luck, int speed, int memory){
      
      stats[0] = strength;
      stats[1] = cunning;
      stats[2] = luck;
      stats[3] = speed;
      stats[4] = memory;
   }
   
   
   public int getValue(int value){
      return stats[value];
   }
   
   public int[] getList(){
      return stats;
   }
   
   public void incrementStats(int atr1, int value1, int atr2, int value2){
      stats[atr1] += value1;
      stats[atr2] += value2;
   }
   
   
/* public HBox getBox(SimpleIntegerProperty atr){
      
      return box;
   } 
   
   public void equipItem(){
      
   } */
   
}