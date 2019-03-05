import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;

public class PopUpWindow{
   
   Stage window;
   Scene scene;
   
   //constructor
   public PopUpWindow(String message, String btn1, Scene scene){
      
      //nodes (on top of background)
      Label label = new Label(message);
         label.setTextFill(Color.WHITE);
         label.setTextAlignment(TextAlignment.CENTER);
      Button close = new Button(btn1);
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, close);
      layout.setAlignment(Pos.CENTER);
      
      
      //background
      Rectangle outside = new Rectangle(0, 0, 320, 420); //----------------------------------------- maybe black window with white lettering, red lettering
         outside.setFill(Color.rgb(250, 250, 250, 1)); //------------------------------------------- for easter eggs or more impatient messages
      
      Rectangle lineOut = new Rectangle(20, 20, 265, 365);
         lineOut.setFill(Color.rgb(0, 0, 0, 1));
      Rectangle lineIn = new Rectangle(35, 35, 235, 335);
      
      Shape border = Shape.subtract(lineOut, lineIn);
      
      Group group = new Group();
      group.getChildren().addAll(outside, border, layout);
      
      
      //window setup
      scene = new Scene(group, 310, 410);


      window = new Stage();
      window.setResizable(false);
      window.initStyle(StageStyle.UNDECORATED); //removes title bar
      window.initModality(Modality.APPLICATION_MODAL); //prevents you from messing w/ the screen behind
      window.setScene(scene);
      window.showAndWait();


      //close button
      close.setOnAction(e -> {
         //window.hide(); //------------------------------------------------------------------------------------------------------needs to close the window
      });
      
      
   }
    
/* public PopUpWindow(String message, String btn1, String btn2){ }
   public PopUpWindow(String message){ } */
   
}//class





/*//////transparent rectangle////////////////////////////////////////////
      Group group = new Group();
      Rectangle rect = new Rectangle(0, 0, 320, 420);
      
      rect.setFill(Color.rgb(140, 140, 140, 0.5));
      //rect.setFill(Color.TRANSPARENT);
      group.getChildren().add(rect);
      
      Scene scene = new Scene(group);
      scene.setFill(Color.TRANSPARENT);
      //stage.initStyle(StageStyle.TRANSPARENT);
      stage.setScene(scene);
      stage.show();
*//*//////////////////////////////////////////////////////////////////////
      Group group = new Group();
      Rectangle outside = new Rectangle(0, 0, 320, 420);
         outside.setFill(Color.rgb(140, 140, 140, 0.5));
      Rectangle inside = new Rectangle(10, 10, 100, 80);
         inside.setFill(Color.rgb(0, 0, 0, 0.5));
      group.getChildren().addAll(outside, inside);
      
      Scene scene = new Scene(group);
      scene.setFill(Color.TRANSPARENT);
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setScene(scene);
      stage.show();
*/