import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.binding.*;

public class AttributeStat{
   
   private final HBox  box;
   //private final Label value;
   
   public AttributeStat(String name){
      
      box = new HBox(15, atrName(name));//box = new HBox(15, atrName(name), value);
   }
   
   private static Label atrName(String name){
      Label atrName = new Label(name);
      atrName.setPrefSize(60, 20);
      return atrName;
   }
   
/* private static Label value(_____){
      Label value = new Label("" + _____);
      label.setPrefSize(30, 20);
      return value;
   } */
   
   public HBox getBox(){
      return this.box;
   }

}