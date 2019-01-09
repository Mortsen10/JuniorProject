/*

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;//Insets

public class CharacterItem{

   public void secondScene(){
      
      final ToggleGroup buttons = new ToggleGroup();
      
      RadioButton shoes = new RadioButton("a shiny pair of red galoshes");//makes a label to the right
         shoes.setToggleGroup(buttons);
         GridPane.setConstraints(shoes, 0, 0);
      RadioButton wHat = new RadioButton("a witch's hat, the edges are lightly frayed");
         wHat.setToggleGroup(buttons);
         GridPane.setConstraints(wHat, 0, 1);
      RadioButton scarf = new RadioButton("a forest green scarf");
         scarf.setToggleGroup(buttons);
         GridPane.setConstraints(scarf, 0, 2);
      RadioButton sHat = new RadioButton("a safari hat");
         sHat.setToggleGroup(buttons);
         GridPane.setConstraints(sHat, 0, 3);
      RadioButton hands = new RadioButton("nothing. i only need my bare hands");
         hands.setToggleGroup(buttons);
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

*/