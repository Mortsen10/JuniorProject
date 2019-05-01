import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;

public class CharacterStats{
   
   private int[]    stats    = new int[5];
   private ArrayList<String> upgrades /*assigns an object a reference*/ = new ArrayList<String>();/*creates the object / new memory*/
   String item, name;
   int money;
   
   //constructor
   public CharacterStats(int strength, int cunning, int luck, int speed, int memory, String name){
      stats[0] = strength;
      stats[1] = cunning;
      stats[2] = luck;
      stats[3] = speed;
      stats[4] = memory;
      this.name = name;
      this.money = 10;
   }
   
   public void newStats(int strength, int cunning, int luck, int speed, int memory, String name){
      stats[0] = strength;
      stats[1] = cunning;
      stats[2] = luck;
      stats[3] = speed;
      stats[4] = memory;
      this.name = name;
   }
   
   public int getValue(int value){
      return stats[value];
   }
   
   public int[] getList(){
      return stats;
   }
   
   public String getName(){
      return this.name;
   }
   
   public int getMoney(){
      return this.money;
   }
   
   public void addMoney(int n){
      this.money += n;
   }
   
   public void incrementStats(int atr1, int value1, int atr2, int value2){
      stats[atr1] += value1;
      stats[atr2] += value2;
   }
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public void equipItem(String itemName){
      
   }
   
   public void dropItem(){
      
   }
   
}