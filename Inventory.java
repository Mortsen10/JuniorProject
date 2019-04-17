import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;
import java.util.*;

public class Inventory{
   
   private ListView<String> list;
   private ArrayList<ItemStack> inventory = new ArrayList<String>();
   
   public Inventory(){
      list = new ListView<String>();
         list.setPrefWidth(320);
         list.setPrefHeight(420);
   }
   
   public ListView showList(){
         //return inventory;
         list.setItems(inventory);
   }
   
   
   
   
   
   
   
   public void addItems(String string){
      //if (inventory == null){
         //Label that says "nothing but dust..."
      //}
      
      //inventory.getItems().add(string);
      inventory.add(string);
   }
   
   public void dropItems(){
   } 
}