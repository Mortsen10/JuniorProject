import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class PopUpWindow{
   
   Stage window;
   Scene scene;
   
   //constructor
   public PopUpWindow(String message, String btn1){
      Label label = new Label(message);
      Button name = new Button(btn1);
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, name);
      layout.setAlignment(Pos.CENTER);
      
      scene = new Scene(layout, 250, 80);
      window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
      window.setScene(scene);
      
      window.showAndWait();
      
   }
   
   //public void nameRemind(){
   //}
   
   //public void tokensWindow(){
   //}
   
}//class