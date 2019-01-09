import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CharacterSetup extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(20); //grid.setHgap(15);
      
      Label out = new Label("welcome. select your character attributes. but be careful,\nas these cannot be changed later on.");
      GridPane.setConstraints(out, 0, 0);
      
      Label name = new Label("name your character:");
      TextField nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("sasha");//default text (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 1);
      
      ////////////////////////////////////////////////////////////////////////////////make attribute Nodes
      Attribute strength = new Attribute("strength");
         GridPane.setConstraints(strength, 0, 2);
      Attribute cunning = new Attribute("cunning");
         GridPane.setConstraints(cunning, 0, 3);
      Attribute luck = new Attribute("luck");
         GridPane.setConstraints(luck, 0, 4);
      Attribute speed = new Attribute("speed");
         GridPane.setConstraints(speed, 0, 5);
      Attribute memory = new Attribute("memory");
         GridPane.setConstraints(memory, 0, 6);
      
      Label distPoints = new Label("10");
      Label labelPoints = new Label("distributable points:");
      HBox points = new HBox(5);
      points.getChildren().addAll(labelPoints, distPoints);
      GridPane.setConstraints(points, 0, 7);
      
      Button submit = new Button("submit");
      GridPane.setConstraints(submit, 0, 8);
      
      grid.getChildren().addAll(out, naming, strength, cunning, luck, speed, memory, points, submit);
      
      Scene scene = new Scene(grid, 320, 420);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
/*    
      plus.setOnAction(e -> label.setText("plus"));
      minus.setOnAction(e -> label.setText("minus"));
*/    
      submit.setOnAction(e -> {
         secondScene();
         primaryStage.hide();
       }); // switch to next scene
      
   }//main
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
      
      Scene scene = new Scene(layout, 320, 420);
      
      Stage secondStage = new Stage();
      secondStage.setScene(scene);
      secondStage.setTitle("Title of Game");
      secondStage.show();

   }
   
}//class
