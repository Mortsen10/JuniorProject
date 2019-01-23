import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.binding.*;

public class Attribute{
   
   private final HBox           box;
   private final Button         plus, minus;
   private final Label          label;
   private final AttributeValue value;
   
   //constructor
   public Attribute(String name, IntValue parent, int startValue){
      
      plus = plus();
      minus = minus();
      label = label(startValue);
      value = new AttributeValue(name, parent, startValue);
      
      if (parent != null){
         box = new HBox(15, atrName(name), label, plus, minus);
      }else{
         box = new HBox(15, atrName(name), label);
      }
      
      //button actions
      plus.setOnAction(e -> value.increment());
      minus.setOnAction(e -> value.decrement());
      
      //binds value to label
      label.textProperty()/*property is a wrapper and notifys when changed*/.bind(Bindings.convert/*converts Int to String*/(value.getAtrProperty()));
   }
   
   
   //create nodes
   private static Label atrName(String name){
      Label atrName = new Label(name);
      atrName.setPrefSize(60, 20);
      return atrName;
   }
   
   private static Label label(int startValue){
      Label label = new Label("" + startValue);
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
   
   
   public HBox getBox(){
      return this.box;
   }
   
   public IntValue getParent(){
      return this.value;
   }
   
   public int getValue(){
      return value.getValue();
   }

}//class