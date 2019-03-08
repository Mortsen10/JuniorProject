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
   public PopUpWindow(String message, String btn1){
      
      //nodes (on top of background)
      Label label = new Label(message);
         label.setTextFill(Color.BLACK);
         label.setTextAlignment(TextAlignment.CENTER);
      Button close = new Button(btn1);
         close.setPrefSize(80, 20);
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, close);
      layout.setAlignment(Pos.CENTER);
      GridPane grid = new GridPane();
      grid.setVgap(1);
      grid.setHgap(1);
      grid.setConstraints(layout, 62, 100);
      grid.getChildren().addAll(layout);
      
      //background
      Rectangle outside = new Rectangle(0, 0, 320, 440); //--------------------------------------- maybe black window with white lettering,
         outside.setFill(Color.rgb(250, 250, 250, 1)); //----------------------------------------- red lettering for easter eggs or more
      Rectangle lineOut = new Rectangle(20, 20, 265, 395); //------------------------------------- impatient messages
         lineOut.setFill(Color.rgb(0, 0, 0, 1));
      Rectangle lineIn = new Rectangle(35, 35, 235, 365);
      Shape border = Shape.subtract(lineOut, lineIn);
      Group group = new Group();
      group.getChildren().addAll(outside, border, grid);
      
      //close button
      close.setOnAction(e -> window.close());
      
      //window setup
      scene = new Scene(group, 310, 440);
      window = new Stage();
      window.setResizable(false);
      window.initStyle(StageStyle.UNDECORATED); //removes title bar
      window.initModality(Modality.APPLICATION_MODAL); //prevents you from messing w/ the screen behind
      window.setScene(scene);
      window.showAndWait(); //NEEDS to be last so that the button action will be tied to the button, before it is blocked by showAndWait()
   }
   
   
   public PopUpWindow(String message, String btn1, String btn2){
   
      //nodes (on top of background)
      Label label = new Label(message);
         label.setTextFill(Color.BLACK);
         label.setTextAlignment(TextAlignment.CENTER);
      Button one = new Button(btn1);
         //one.setPrefSize();
      Button two = new Button(btn2);
         //two.setPrefSize();
      HBox buttons = new HBox(10);
      buttons.getChildren().addAll(one, two);
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, buttons);
      layout.setAlignment(Pos.CENTER);
      GridPane grid = new GridPane();
      grid.setVgap(1);
      grid.setHgap(1);
      grid.setConstraints(layout, 62, 100);
      grid.getChildren().addAll(layout);
      
      //background
      Rectangle outside = new Rectangle(0, 0, 320, 420);
         outside.setFill(Color.rgb(250, 250, 250, 1));
      Rectangle lineOut = new Rectangle(20, 20, 265, 365);
         lineOut.setFill(Color.rgb(0, 0, 0, 1));
      Rectangle lineIn = new Rectangle(35, 35, 235, 335);
      Shape border = Shape.subtract(lineOut, lineIn);
      Group group = new Group();
      group.getChildren().addAll(outside, border, grid);
      
      //window setup
      scene = new Scene(group, 310, 410);
      window = new Stage();
      window.setResizable(false);
      window.initStyle(StageStyle.UNDECORATED);
      window.initModality(Modality.APPLICATION_MODAL);
      window.setScene(scene);
      window.showAndWait();
      
      /*//choices
      one.setOnAction(e -> {
         return true;
         window.close();
      });
      two.setOnAction(e -> {
         return false;
         window.close();
      });*/
      
      one.setOnAction(e -> {
         PopUpWindow yesImSure = new PopUpWindow("FINE. your are awfully\nannoying by the way", "cash out", points, stats);
            //show ("+" + points.getValue()/10)
         stats.newStats(strength.getValue(), cunning.getValue(), luck.getValue(), speed.getValue(), memory.getValue(), nameIn.getText());
         secondScene(stats);
         primaryStage.hide();
       });
       two.setOnAction(e -> {
         notSpent++;
         PopUpWindow noImNotSure = new PopUpWindow("please just hurry up. i want to go home");
       });
   }
   
   
   public PopUpWindow(String message, String btn1, Attribute points, CharacterStats stats){
      
      //nodes (on top of background)
      Label label = new Label(message);
         label.setTextFill(Color.BLACK);
         label.setTextAlignment(TextAlignment.CENTER);
      Button close = new Button(btn1);
         close.setPrefSize(80, 20);
      VBox layout = new VBox(10);
      layout.getChildren().addAll(label, close);
      layout.setAlignment(Pos.CENTER);
      GridPane grid = new GridPane();
      grid.setVgap(1);
      grid.setHgap(1);
      grid.setConstraints(layout, 62, 100);
      grid.getChildren().addAll(layout);
      
      //background
      Rectangle outside = new Rectangle(0, 0, 320, 440);
         outside.setFill(Color.rgb(250, 250, 250, 1));
      Rectangle lineOut = new Rectangle(20, 20, 265, 395);
         lineOut.setFill(Color.rgb(0, 0, 0, 1));
      Rectangle lineIn = new Rectangle(35, 35, 235, 365);
      Shape border = Shape.subtract(lineOut, lineIn);
      Group group = new Group();
      group.getChildren().addAll(outside, border, grid);
      
      //close button
      close.setOnAction(e -> {
         stats.addMoney(points.getValue()/10);
         window.close();
      });
      
      //window setup
      scene = new Scene(group, 310, 440);
      window = new Stage();
      window.setResizable(false);
      window.initStyle(StageStyle.UNDECORATED);
      window.initModality(Modality.APPLICATION_MODAL);
      window.setScene(scene);
      window.showAndWait();
   }

}//class