import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.binding.*;

public class Attribute{
   
   private final HBox box;
   private final Button plus, minus;
   private final Label label;
   private final IntValue value;
 //private final DistPtsValue dpValue;
   
   private static Label atrName(String name){
      Label atrName = new Label(name);
      atrName.setPrefSize(60, 20);
      return atrName;
   }
   
   private static Label label(){
      Label label = new Label("" + 0);
      label.setPrefSize(30, 20);
      return label;
   }
   
   private static Button plus(){
      Button plus = new Button("+");
      plus.setPrefSize(25, 10);
      return plus;
   }
   
   private static Button minus(){
      Button minus = new Button("-");
      minus.setPrefSize(25, 20);
      return minus;
   }

   public Attribute(String name){///////////////////////////////////////////////////////////// constructor
      
      plus = plus();
      minus = minus();
      label = label();
      value = new IntValue(name);
    //dpValue = new DistPtsValue();
      
      box = new HBox(15, atrName(name), label, plus, minus);
      
      plus.setOnAction(e -> {
         value.increment();
       //dpValue.decrement();
      });
      minus.setOnAction(e -> {
         value.decrement();
       //dpValue.increment();
      });
      
      label.textProperty()/*property is a wrapper and notifys when changed*/.bind(Bindings.convert/*converts Int to String*/(value.getAtrProperty()));
   }
   
   
   public HBox getBox(){
      return this.box;
   }

}//class
