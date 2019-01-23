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
      Attribute points = new Attribute("Tokens:", null, 100);
      GridPane.setConstraints(points.getBox(), 0, 7);
      
      //attributes
      Attribute strength = new Attribute("strength", points.getParent(), 0);
         GridPane.setConstraints(strength.getBox(), 0, 2);
      Attribute cunning = new Attribute("cunning", points.getParent(), 0);
         GridPane.setConstraints(cunning.getBox(), 0, 3);
      Attribute luck = new Attribute("luck", points.getParent(), 0);
         GridPane.setConstraints(luck.getBox(), 0, 4);
      Attribute speed = new Attribute("speed", points.getParent(), 0);
         GridPane.setConstraints(speed.getBox(), 0, 5);
      Attribute memory = new Attribute("memory", points.getParent(), 0);
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
      
         //if (nameIn == null){ //no name
         //if (tokens.getValue() != 0){ //not all tokens used
         
         //if ((nameIn != null) && (points.getValue == 0)){//everything is filled out
            CharacterStats stats = new CharacterStats(strength.getValue(), cunning.getValue(), luck.getValue(), speed.getValue(), memory.getValue());
            secondScene(stats);
            primaryStage.hide();
         //}//if
      });
      
   }//main
   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public void secondScene(CharacterStats stats){
      
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
         if (buttons.getSelectedToggle() != null){
               if (buttons.getSelectedToggle() == shoes){
                  stats.incrementStats(2, 10, 3, 5);
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == wHat){
                  stats.incrementStats(1, 10, 0, 5);
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == scarf){
                  stats.incrementStats(4, 10, 1, 5);
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == sHat){
                  stats.incrementStats(3, 10, 4, 5);
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == hands){
                  stats.incrementStats(0, 15, 0, 0);
                  //stats.equipItem(____);
               }else{
                  System.out.println("hello wayward traveler. how did you get all the way down here?");
               }
            mainScreen(stats);
            secondStage.hide();
         //}else{
            //window pops up, "every adventurer needs a signaure look"
         }//if
      });
      
   }//second screen
   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
   public void mainScreen(CharacterStats stats){
      
      //buttons
      Button explore = new Button("EXPLORE");
         GridPane.setConstraints(explore, 2, 3);
         explore.setPrefSize(210, 15);
      Button statsBtn = new Button("stats");
         statsBtn.setPrefSize(90, 15);
      Button items = new Button("items");
         items.setPrefSize(90, 15);
      Button backpack = new Button("backpack");
         backpack.setPrefSize(90, 15);
      
      //stack buttons
      HBox btns1 = new HBox(30);
         GridPane.setConstraints(btns1, 2, 4);
         btns1.getChildren().addAll(statsBtn, backpack);
      HBox btns2 = new HBox();
         GridPane.setConstraints(btns2, 2, 5);
         btns2.getChildren().addAll(items);

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
      
      //button actions
      //explore.setOnAction(e -> map());
      statsBtn.setOnAction(e -> {
         stats(stats);
         mainStage.hide();
      });
      //backpack.setOnAction(e -> backpack());
      //items.setOnAction(e -> items());

   }//main screen
   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public void stats(CharacterStats stats){
      
      //grid setup
      GridPane grid = new GridPane();
      grid.setVgap(10);
      grid.setPadding(new Insets(10, 10, 10, 10));
            
      //top bar
      Button back = new Button("<back");
      Label label = new Label("stats");
      HBox top = new HBox(85);
      top.getChildren().addAll(back, label);
      GridPane.setConstraints(top, 0, 0);
      
      //name
      Label name = new Label("name: "/*take name and convert to ruins*/);
      GridPane.setConstraints(name, 0, 2);
      
      //attributes //-----------------------------------------------------------------set as observable, chages as stats change
      AttributeStat strength = new AttributeStat("strength:");
         GridPane.setConstraints(strength.getBox(), 0, 4);
      AttributeStat cunning = new AttributeStat("cunning:");
         GridPane.setConstraints(cunning.getBox(), 0, 5);
      AttributeStat luck = new AttributeStat("luck:");
         GridPane.setConstraints(luck.getBox(), 0, 6);
      AttributeStat speed = new AttributeStat("speed:");
         GridPane.setConstraints(speed.getBox(), 0, 7);
      AttributeStat memory = new AttributeStat("memory:");
         GridPane.setConstraints(memory.getBox(), 0, 8);
         
            //values
      
      //equiped items
      
      //money
      Label coin = new Label("coin pouch:");
      Label coinValue = new Label("" + 0);
      HBox coins = new HBox(10);
      coins.getChildren().addAll(coin, coinValue);
      GridPane.setConstraints(coins, 0, 15);
      
      //window setup
      grid.getChildren().addAll(top, name, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), coins);
      Scene scene = new Scene(grid, 320, 420);
      Stage statsStage = new Stage();
      statsStage.setScene(scene);
      statsStage.setTitle("Title of Game");
      statsStage.show();
      
      //button actions
      back.setOnAction(e -> {
         mainScreen(stats);
         statsStage.hide();
      });
      
  }//stats
   
/*   
   public void backpack(){
      
   }//backpack
   
   public void items(){
      
   }//items
   
   public void map(){
      
   }//map
  
*/

}//class

/*Label strength = new Label("strength:");
         GridPane.setConstraints();
      Label val0 = new Label(""+ stats.getStats(0));
         GridPane.setConstraints(val0, 0, 2);
      
      Label cunning = new Label("cunning:");
         GridPane.setConstraints();
      Label val1 = new Label(""+ stats.getStats(1));
         GridPane.setConstraints(val1, 0, 3);
         
      Label luck = new Label("luck:");
         GridPane.setConstraints();
      Label val2 = new Label(""+ stats.getStats(2));
         GridPane.setConstraints(val2, 0, 4);
         
      Label speed = new Label("speed:");
         GridPane.setConstraints();
      Label val3 = new Label(""+ stats.getStats(3));
         GridPane.setConstraints(val3, 0, 5);
         
      Label memory = new Label("memory:");
         GridPane.setConstraints();
      Label val4 = new Label(""+ stats.getStats(4));
         GridPane.setConstraints(val4, 0, 6);*/