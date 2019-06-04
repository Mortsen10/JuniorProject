import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;

public class ItemStack{
   
   private String item;
   private int    value;
   
   public ItemStack(String n, int sV){
      item = n;
      value = sV;
      Label name = new Label(item);
      Label startVal = new Label(value + "");
      
      HBox box = new HBox(30, name, startVal);
   }
   
   public ItemStack(String n){
      item = n;
      Label name = new Label(item);
      HBox box = new HBox(30, name);
   }
   
   
   public void stackItem(int n){
      value += n;
   }
   
   public void takeItem(int n){
      value -= n;
   }
   
   public String getName(){
      return this.item;
   }
   
   public int getValue(){
      return value;
   }
   
   public String toString(){
      return this.item.toString();
   }
}