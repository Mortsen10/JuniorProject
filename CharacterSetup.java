/*
** If I can figure out how to not switch screens, but instead show and hide layouts,
** I can show and hide the buttons on the main screen to add to the plot of the game.
** 
*/

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CharacterSetup extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      // instead of a label, I want to be able to 
      //show and hide text somewhere on the screen
      Label out = new Label("welcome. select your character attributes. but be careful,\nas these cannot be changed later on.");
      GridPane.setConstraints(out, 0, 0);
      
      //name input
      Label name = new Label("what should we call you?");
      TextField nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("sasha");//default text (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 1);
      
      //distributable points
      Attribute points = new Attribute("Tokens:", null, 10);
      GridPane.setConstraints(points.getBox(), 0, 7);
      
      //attributes
      Attribute strength = new Attribute("strength", points.getValue(), 0);
         GridPane.setConstraints(strength.getBox(), 0, 2);
      Attribute cunning = new Attribute("cunning", points.getValue(), 0);
         GridPane.setConstraints(cunning.getBox(), 0, 3);
      Attribute luck = new Attribute("luck", points.getValue(), 0);
         GridPane.setConstraints(luck.getBox(), 0, 4);
      Attribute speed = new Attribute("speed", points.getValue(), 0);
         GridPane.setConstraints(speed.getBox(), 0, 5);
      Attribute memory = new Attribute("memory", points.getValue(), 0);
         GridPane.setConstraints(memory.getBox(), 0, 6);
      
      //next screen button
      HBox submit = new HBox();
      submit.setAlignment(Pos.CENTER_RIGHT);
      Button submitBtn = new Button("next");
      submit.getChildren().addAll(submitBtn);
      GridPane.setConstraints(submit, 0, 8);
      
      //grid setup
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(20);
      grid.getChildren().addAll(out, naming, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), points.getBox(), submit);
      
      //window setup
      Scene scene = new Scene(grid, 320, 420);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
      
    //button actions
      submitBtn.setOnAction(e -> {
         secondScene();
         primaryStage.hide();
       }); 
      
   }//main
   


   public void secondScene(){
      
      //buttons
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
      
      //next screen
      Button submit = new Button("next");
         GridPane.setConstraints(submit, 1, 10);
      
      //grid setup
      GridPane layout = new GridPane();
      layout.setVgap(15);
      layout.setHgap(10);
      layout.setPadding(new Insets(10, 10, 10, 10));
      layout.getChildren().addAll(shoes, wHat, scarf, sHat, hands, submit);
      
      //window setup
      Scene scene = new Scene(layout, 320, 420);
      Stage secondStage = new Stage();
      secondStage.setScene(scene);
      secondStage.setTitle("Title of Game");
      secondStage.show();
      
      //button actions
      submit.setOnAction(e -> {
         mainScreen();
         secondStage.hide();
      });

   }//second screen
   
   
   
   public void mainScreen(){
      
      //buttons
      Button explore = new Button("EXPLORE");
         GridPane.setConstraints(explore, 2, 3);
         explore.setPrefSize(210, 15);
      Button stats = new Button("stats");
         stats.setPrefSize(90, 15);
      Button items = new Button("items");
         items.setPrefSize(90, 15);
      Button backpack = new Button("backpack");
         backpack.setPrefSize(90, 15);
      
      //stack buttons
      HBox btns1 = new HBox(30);
         GridPane.setConstraints(btns1, 2, 4);
         btns1.getChildren().addAll(stats, backpack);
      HBox btns2 = new HBox();
         GridPane.setConstraints(btns2, 2, 5);
         btns2.getChildren().addAll(items);
      
/*    Label out = new Label("welcome");
**      
**    BorderPane pane = new BorderPane();
**    pane.setCenter(grid);
**    pane.setBottom(out);  */

      //grid setup
      GridPane grid = new GridPane();
      grid.setVgap(15);
      grid.setHgap(20);
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.getChildren().addAll(explore, btns1, btns2);
      
      //window setup
      Scene scene = new Scene(grid, 320, 420);
      Stage mainStage = new Stage();
      mainStage.setScene(scene);
      mainStage.setTitle("Title of Game");
      mainStage.show();
      
/*    //button actions
      explore.setOnAction(e -> map());
      stats.setOnAction(e -> stats());
      backpack.setOnAction(e -> backpack());
      items.setOnAction(e -> items()); */

   }//main screen
   
   
   
/*
   public void stats(){
      
   }//stats
   
   public void backpack(){
      
   }//backpack
   
   public void items(){
      
   }//items
   
   public void map(){
      
   }//map
*/
   
   
   
   
}//class