import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;
import java.util.*;
import javafx.collections.*;

public class Inventory{
   
   private ListView<ItemStack> list;
   private ObservableList<ItemStack> inventory;
   ItemStack dust = new ItemStack("nothing but dust...");
   
   public Inventory(){
      list = new ListView<ItemStack>();
         list.setPrefWidth(320);
         list.setPrefHeight(420);
      inventory = FXCollections.observableArrayList();
      inventory.add(dust);
   }
   
   public ListView showList(){
      return list;
   }
   
   
   public void addItem(ItemStack item, int n){
      if(inventory.get(0) == dust){//reasign the first position
         inventory.remove(0);
         inventory.add(0, item);
      }
      if(inventory.contains(item)){
         item.stackItem(n);
      }else{
         inventory.add(item);
      }
   }
   
   public void useItem(ItemStack item, int n, TextArea text){
      int i = item.getValue();
      
      if((i -= n) == -1){
         text.appendText("not enough" + item.getName());//"you need" + /*# of items needed*/ + "more" + item.getName()
      }else{
         item.takeItem(n);
      }/*
      if(item.getValue() == 0){
         inventory.remove(item.getIndex());
      }
      if(inventory == null){
         inventory.add(dust);
      }*/
   }
   
}