import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;//Insets

public class CharacterItem extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      CheckBox shoes = new CheckBox("a shiny pair of red galoshes");//makes a label to the right
         GridPane.setConstraints(shoes, 0, 0);
      CheckBox wHat = new CheckBox("a witch's hat, the edges are lightly frayed");
         GridPane.setConstraints(wHat, 0, 1);
      CheckBox scarf = new CheckBox("a forest green scarf");
         GridPane.setConstraints(scarf, 0, 2);
      CheckBox sHat = new CheckBox("a safari hat");
         GridPane.setConstraints(sHat, 0, 3);
      CheckBox hands = new CheckBox("nothing. i only need my bare hands");
         GridPane.setConstraints(hands, 0, 4);
      
      Button submit = new Button("submit");
         GridPane.setConstraints(submit, 1, 10);
      
      GridPane layout = new GridPane();
      layout.setVgap(15);
      layout.setHgap(10);
      layout.setPadding(new Insets(10, 10, 10, 10));
      layout.getChildren().addAll(shoes, wHat, scarf, sHat, hands, submit);
      
      Scene scene = new Scene(layout, 320, 400);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
      
   }//main

}//class