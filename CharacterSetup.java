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
      
      Label name = new Label("name your character:");///////////////////// name input
      TextField nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("sasha");//default text (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 1);
      
      
      Attribute points = new Attribute("Points:", null);///////////////////////..............
      GridPane.setConstraints(points.getBox(), 0, 7);
      
      Attribute strength = new Attribute("strength", points.getValue());/////////////////// attributes
         GridPane.setConstraints(strength.getBox(), 0, 2);
      Attribute cunning = new Attribute("cunning", points.getValue());
         GridPane.setConstraints(cunning.getBox(), 0, 3);
      Attribute luck = new Attribute("luck", points.getValue());
         GridPane.setConstraints(luck.getBox(), 0, 4);
      Attribute speed = new Attribute("speed", points.getValue());
         GridPane.setConstraints(speed.getBox(), 0, 5);
      Attribute memory = new Attribute("memory", points.getValue());
         GridPane.setConstraints(memory.getBox(), 0, 6);
      
      
      Button submit = new Button("submit");
      GridPane.setConstraints(submit, 0, 8);
      
      grid.getChildren().addAll(out, naming, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), points.getBox(), submit);
      
      Scene scene = new Scene(grid, 320, 420);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
      
      submit.setOnAction(e -> {/////////////// scene switch
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
      
      submit.setOnAction(e -> {
         mainScreen();
         secondStage.hide();
      });

   }
   
   public void mainScreen(){
      
      GridPane grid = new GridPane();
      grid.setVgap(15);
      grid.setHgap(20);
      grid.setPadding(new Insets(10, 10, 10, 10));
      
      Button explore = new Button("EXPLORE");
         GridPane.setConstraints(explore, 2, 3);
         explore.setPrefSize(210, 15);
      Button stats = new Button("stats");
         stats.setPrefSize(90, 15);
      Button items = new Button("items");
         items.setPrefSize(90, 15);
      Button backpack = new Button("backpack");
         backpack.setPrefSize(90, 15);
      
      HBox btns1 = new HBox(30);
         GridPane.setConstraints(btns1, 2, 4);
         btns1.getChildren().addAll(stats, backpack);
      HBox btns2 = new HBox();
         GridPane.setConstraints(btns2, 2, 5);
         btns2.getChildren().addAll(items);
      
      grid.getChildren().addAll(explore, btns1, btns2);
      
/*    
**    Label out = new Label("welcome");
**      
**    BorderPane pane = new BorderPane();
**    pane.setCenter(grid);
**    pane.setBottom(out);
*/

      Scene scene = new Scene(grid, 320, 420);
      
      Stage mainStage = new Stage();
      mainStage.setScene(scene);
      mainStage.setTitle("Title of Game");
      mainStage.show();
/*
      explore.setOnAction(e -> map());
      stats.setOnAction(e -> stats());
      backpack.setOnAction(e -> backpack());
      items.setOnAction(e -> items());
*/
   }
   
   public void map(){
      
   }
   
}//class
