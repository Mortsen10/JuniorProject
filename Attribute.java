import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Attribute extends HBox{
   
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

   public Attribute(String name){///////////////////////////////constructor
      super(15, atrName(name), label(), plus(), minus());
   }
   
   
   public int increment(int value){
      value++;
      return value;
   }
   
   public int decrement(int value){
      value--;
      return value;
   }
   
}//class
