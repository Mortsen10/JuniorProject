import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;

public class ItemStack{
   
   public ItemStack(String n, int sV){
      Label name = new Label(n);
      Label startVal = new Label(sV + "");
      
      HBox box = new HBox(30, name, startVal);
   }
   
}