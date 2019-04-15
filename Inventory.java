import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;

public class Inventory{
   
   private ListView<String> inventory;
   
   public Inventory(){
      inventory = new ListView<String>();
         inventory.setPrefWidth(320);
         inventory.setPrefHeight(420);
   }
   
   public void addItems(String string){
      inventory.getItems().add(string);
   }
   

   public ListView showList(){
      
      //if (inventory == null){
         
      //}else{
         return inventory;
      //}
      
   }
   
}