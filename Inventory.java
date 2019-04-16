import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;

public class Inventory{
   
   private ListView<String> inventory;
   //private ArrayList<String> inventory = new ArrayList("nothing but dust...");
   
   public Inventory(){
      inventory = new ListView<String>();
         inventory.setPrefWidth(320);
         inventory.setPrefHeight(420);
         
         //inventory.add("nothing but dust...");
   }
   
   public void addItems(String string){
      //if (inventory == null){
         
      //}
      
      inventory.getItems().add(string);
   }
   

   public ListView showList(){
      
      //if (inventory == null){
         
      //}else{
         return inventory;
      //}
      
   }
   
}