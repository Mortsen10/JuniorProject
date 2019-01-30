import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.binding.*;

public class AttributeStat{
   
   //private final Label         label;
   //private final AttributeStat value;
   private final HBox  box;
   
   
   //constructor
   public AttributeStat(String name){//, int stat)
      
      
      box = new HBox(15, atrName(name));//(15, atrName(name), value)
      
      //binds value to label
      //label.textProperty().bind(Bindings.convert(value.getStat(stat)));
   }
   
   //nodes
   private static Label atrName(String name){
      Label atrName = new Label(name);
      atrName.setPrefSize(60, 20);
      return atrName;
   }
   
/*   private static Label label(int stat){
      Label value = new Label("" + value.getStat(stat));
      label.setPrefSize(30, 20);
      return value;
   } */
   
   
   
   public HBox getBox(){
      return this.box;
   }

}