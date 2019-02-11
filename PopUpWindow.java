import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.shape.*;

public class PopUpWindow{
   
   Stage window;
   Scene scene;
   
   //constructor
   public PopUpWindow(String message, String btn1){
      
////////background////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      Rectangle background = new Rectangle(0, 420, 320, 420); //(x, y, width, height) -> (x,y) is the upper left-hand corner
      background.getFill(); //default color is black
      //background.scene.setFill(Color.TRANSPARENT);
/*
       Group group = new Group();
       shape.setFill(Color.GRAY);
       group.getChildren().add(shape);
       Scene scene = new Scene(group);
       scene.setFill(Color.TRANSPARENT);
       stage.setScene(scene);
       stage.show();
*/
      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      //nodes (on top of background)
      Label label = new Label(message);
      Button name = new Button(btn1); //--------------------------------------------------------------------------needs to close the window
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, name);
      layout.setAlignment(Pos.CENTER);
      
      //window setup
      scene = new Scene(layout, 250, 80);
      window = new Stage();
      window.setResizable(false);
      window.initStyle(StageStyle.UNDECORATED); //removes title bar
      window.initModality(Modality.APPLICATION_MODAL); //prevents you from messing w/ the screen behind
      window.setScene(scene);
      
      window.showAndWait();
   }
    
/* public PopUpWindow(String message, String btn1, String btn2){
      
   }
   
   public PopUpWindow(String message){
      
   }*/
   
}//class