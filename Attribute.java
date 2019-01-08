import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Attribute extends Region{

private String name;
   
   public Attribute(String name){
      Label atrName = new Label(this.name);
      atrName.setPrefSize(60, 20);
      
      Label label = new Label("" + 0);
      label.setPrefSize(30, 20);
      
      Button plus = new Button("+");
      plus.setPrefSize(25, 10);
      
      Button minus = new Button("-");
      minus.setPrefSize(25, 20);
      
      HBox attribute = new HBox(15, atrName, label, plus, minus);
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

/*   
   public HBox toLayout(){
      HBox attribute = new HBox(15, this.name, label, plus, minus);
   }
*/ 