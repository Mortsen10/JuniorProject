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
import javafx.beans.property.*;

public class Main extends Application{
   
   int notSpent = 0;
   
   @Override
   public void start(Stage primaryStage) throws Exception{
      
      CharacterStats stats = new CharacterStats(0, 0, 0, 0, 0, null);
      
      //next screen button
      HBox submit = new HBox();
      submit.setAlignment(Pos.CENTER_RIGHT);
      Button submitBtn = new Button("next");
      submit.getChildren().addAll(submitBtn);
      GridPane.setConstraints(submit, 0, 7);
      
      //distributable points
      Attribute points = new Attribute("Tokens:", null, 100);
      GridPane.setConstraints(points.getBox(), 0, 6);
      
      //HBox submit = new HBox();
      //submit.getChildren().addAll(points.getBox(), submitBtn);
      //submitBtn.setAlignment(Pos.CENTER_RIGHT);
      //GridPane.setConstraints(submit, 0, 7);
      
      //name input
      Label name = new Label("what should we call you?");
      TextField nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("name");//default text (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 0);
      
      //attributes
      Attribute strength = new Attribute("strength", points.getParent(), 0);
         GridPane.setConstraints(strength.getBox(), 0, 1);
      Attribute cunning = new Attribute("cunning", points.getParent(), 0);
         GridPane.setConstraints(cunning.getBox(), 0, 2);
      Attribute luck = new Attribute("luck", points.getParent(), 0);
         GridPane.setConstraints(luck.getBox(), 0, 3);
      Attribute speed = new Attribute("speed", points.getParent(), 0);
         GridPane.setConstraints(speed.getBox(), 0, 4);
      Attribute memory = new Attribute("memory", points.getParent(), 0);
         GridPane.setConstraints(memory.getBox(), 0, 5);
            
      //scrolable text output
      TextArea text = new TextArea("welcome. select your character attributes. but be careful, as these cannot be changed later on.\n");
      text.setEditable(false);
      text.setWrapText(true);
      GridPane.setConstraints(text, 0, 8);
      
      //grid setup
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(20);
      grid.getChildren().addAll(naming, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), points.getBox(), submit, text);
      
      //window setup
      Scene scene = new Scene(grid, 320, 420);
      primaryStage.setScene(scene);
      primaryStage.setResizable(false);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();

      //button actions
      submitBtn.setOnAction(e -> {
         if ((nameIn.getText() == null) || (nameIn.getText().isEmpty())){ //no name
            PopUpWindow nameRemind = new PopUpWindow  ("even the bravest of adventurers needs a name", "continue");
         }else if (points.getValue() != 0){ //not all tokens used
            if (notSpent == 0){
               notSpent++;
               PopUpWindow tokensRemind = new PopUpWindow("continue? and leave money unspent?", "spend");
            }else if (notSpent == 1){
               notSpent++;
               PopUpWindow tokensRemind1 = new PopUpWindow("seriously? you're not going to spend the FREE money i gave to you for FREE?", "spend");
            }else if (notSpent == 2){
               notSpent++;
               PopUpWindow tokensRemind2 = new PopUpWindow("are you sure you're sure?", "yes", "no");
                  if (tokensRemind2.getButton() == true){
                     PopUpWindow yesImSure = new PopUpWindow("FINE. you are awfully annoying by the way", "cash out");
                     stats.addMoney(points.getValue()/10);
                     text.appendText("+" + points.getValue() + "coins\n"); 
                     if(strength.getValue() != 0){
                        text.appendText("+" + strength.getValue() + "strength\n"); //prints out to scrolable text area
                     }if(cunning.getValue() != 0){
                        text.appendText("+" + cunning.getValue() + "cunning\n");
                     }if(luck.getValue() != 0){
                        text.appendText("+" + luck.getValue() + "luck\n");
                     }if(speed.getValue() != 0){
                        text.appendText("+" + speed.getValue() + "speed\n");
                     }if(memory.getValue() != 0){
                        text.appendText("+" + memory.getValue() + "memory\n");
                     }
                     stats.newStats(strength.getValue(), cunning.getValue(), luck.getValue(), speed.getValue(), memory.getValue(), nameIn.getText());
                     secondScene(stats, text);
                     primaryStage.hide();
                  }else if (tokensRemind2.getButton() == false){
                     notSpent++;
                     PopUpWindow noImNotSure = new PopUpWindow("please just hurry up. i want to go home", "continue");
                  }
            }else if (notSpent >= 3){
               PopUpWindow bye = new PopUpWindow("yeah... i'm just 'gonna kick you out", "bye");
               primaryStage.close();
            }
         }
       if ((nameIn != null) && (points.getValue() == 0)){ //everything is filled out
            if(strength.getValue() != 0){
               text.appendText("+" + strength.getValue()/10 + "strength"); //prints out to scrolable text area
            }if(cunning.getValue() != 0){
               text.appendText("+" + cunning.getValue()/10 + "cunning");
            }if(luck.getValue() != 0){
               text.appendText("+" + luck.getValue()/10 + "luck");
            }if(speed.getValue() != 0){
               text.appendText("+" + speed.getValue()/10 + "speed");
            }if(memory.getValue() != 0){
               text.appendText("+" + memory.getValue()/10 + "memory");
            }
            stats.newStats(strength.getValue(), cunning.getValue(), luck.getValue(), speed.getValue(), memory.getValue(), nameIn.getText());
            secondScene(stats, text);
            primaryStage.hide();
         }
      });
   }//main
   
   
   public void secondScene(CharacterStats stats, TextArea text){
      
      GridPane.setConstraints(text, 0, 9);
      
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
      VBox submit = new VBox();
      submit.setAlignment(Pos.CENTER_RIGHT);
      Button submitBtn = new Button("next");
      submit.getChildren().add(submitBtn);
         GridPane.setConstraints(submit, 0, 8);
      
      //grid setup
      GridPane layout = new GridPane();
      layout.setVgap(15);
      layout.setHgap(10);
      layout.setPadding(new Insets(10, 10, 10, 10));
      layout.getChildren().addAll(shoes, wHat, scarf, sHat, hands, submit, text);
      
      //window setup
      Scene scene = new Scene(layout, 320, 420);
      Stage secondStage = new Stage();
      secondStage.setScene(scene);
      secondStage.setResizable(false);
      secondStage.setTitle("Title of Game");
      secondStage.show();
      
      //button actions
      submitBtn.setOnAction(e -> {
         if (buttons.getSelectedToggle() != null){
               if (buttons.getSelectedToggle() == shoes){
                  stats.incrementStats(2, 10, 3, 5);
                  //stats.equipItem(____); //---------------------------------------------------- i want the player to be notified that they got extra 
               }else if (buttons.getSelectedToggle() == wHat){ //-------------------------------- attribute points on the next screen in the text window
                  stats.incrementStats(1, 10, 0, 5); //------------------------------------------ thing. ex: +10 speed, +5 cunning (name of object)
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
               }
            mainScreen(stats, text);
            secondStage.hide();
         }else{
            PopUpWindow itemRemind = new PopUpWindow("every adventurer needs a signaure look", "continue");
         }
      });
   }//second screen
   
   
   public void mainScreen(CharacterStats stats, TextArea text){
            
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
      grid.getChildren().addAll(explore, btns1, btns2, text);
      
      //text output
      GridPane.setConstraints(text, 2, 7); //------------------------------------------------------------------------------------ NEEDS TO SPAN FROM 0 - end of screen
      //grid.getChildren().add(text, int columnIndex, int rowIndex, int colspan, int rowspan);
      
      //window setup
      Scene scene = new Scene(grid, 320, 420);
      Stage mainStage = new Stage();
      mainStage.setScene(scene);
      mainStage.setResizable(false);
      mainStage.setTitle("Title of Game");
      mainStage.show();
      
      //button actions
      //explore.setOnAction(e -> map());
      statsBtn.setOnAction(e -> {
         stat(stats, text);
         mainStage.hide();
      });
      //backpack.setOnAction(e -> backpack());
      //items.setOnAction(e -> items());
   }//main screen
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public void stat(CharacterStats stats, TextArea text){
      
      GridPane.setConstraints(text, 1, 10);
      
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
      Label name = new Label("name: " + stats.getName());
      GridPane.setConstraints(name, 0, 2);
      
      //attributes
      Attribute strength = new Attribute("strength:", null, stats.getValue(0));
         GridPane.setConstraints(strength.getBox(), 0, 4);
      Attribute cunning = new Attribute("cunning:", null, stats.getValue(1));
         GridPane.setConstraints(cunning.getBox(), 0, 5);
      Attribute luck = new Attribute("luck:", null, stats.getValue(2));
         GridPane.setConstraints(luck.getBox(), 0, 6);
      Attribute speed = new Attribute("speed:", null, stats.getValue(3));
         GridPane.setConstraints(speed.getBox(), 0, 7);
      Attribute memory = new Attribute("memory:", null, stats.getValue(4));
         GridPane.setConstraints(memory.getBox(), 0, 8);    
      
      //money
      Label coin = new Label("coin pouch:");
      Label coinValue = new Label("" + stats.getMoney());
      HBox coins = new HBox(10);
      coins.getChildren().addAll(coin, coinValue);
      GridPane.setConstraints(coins, 0, 15);
      
      //window setup
      grid.getChildren().addAll(top, name, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), coins, text);
      Scene scene = new Scene(grid, 320, 420);
      Stage statsStage = new Stage();
      statsStage.setResizable(false);
      statsStage.setScene(scene);
      statsStage.setTitle("Title of Game");
      statsStage.show();
      
      //button actions
      back.setOnAction(e -> {
         mainScreen(stats, text);
         statsStage.hide();
      });
   }//stats
   
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /*
   public void items(){
   
      ListView<String> list = new ListView<String>();
      list.setPrefWidth(320);
      list.setPrefHeight(420);
      
      ObservableList<String> items = FXCollections.observableArrayList("wood");
      ListView<String> listView = new ListView<String>(items);
      
   }//items
   */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*//////////////////////////////////////////
   public void backpack(){
   }//backpack
   
   public void map(){
   }//map
*///////////////////////////////////////////


}//class