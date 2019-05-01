import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.property.*;

public class Main extends Application{
   int notSpent = 0;
   
   private Attribute strength;
   private Attribute cunning;
   private Attribute luck;
   private Attribute speed;
   private Attribute memory;
   
   private TextArea       text;
   private CharacterStats stats;
   private TextField      nameIn;
   
   Inventory inventory = new Inventory();//inventory is not bound? it's not showing what i want
   
   
   @Override
   public void start(Stage primaryStage) throws Exception{
      stats = new CharacterStats(0, 0, 0, 0, 0, null);
      
      //next screen button
      HBox submit = new HBox();
      submit.setAlignment(Pos.CENTER_RIGHT);
      Button submitBtn = new Button("next");
      submit.getChildren().addAll(submitBtn);
      GridPane.setConstraints(submit, 0, 6);
      
      //distributable points
      Attribute points = new Attribute("Tokens:", null, 100);
      GridPane.setConstraints(points.getBox(), 0, 6);
      
      //name input
      Label name = new Label("what should we call you?");
      nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("name");//default text (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 0, 2, 1);
      
      //attributes
      strength = new Attribute("strength", points.getParent(), 0);
         GridPane.setConstraints(strength.getBox(), 0, 1);
      cunning = new Attribute("cunning", points.getParent(), 0);
         GridPane.setConstraints(cunning.getBox(), 0, 2);
      luck = new Attribute("luck", points.getParent(), 0);
         GridPane.setConstraints(luck.getBox(), 0, 3);
      speed = new Attribute("speed", points.getParent(), 0);
         GridPane.setConstraints(speed.getBox(), 0, 4);
      memory = new Attribute("memory", points.getParent(), 0);
         GridPane.setConstraints(memory.getBox(), 0, 5);  
         
      //scrolable text output
      text = new TextArea("welcome. select your character attributes. but be careful, as these cannot be changed later on.\n\n");
      text.setEditable(false);
      text.setWrapText(true);
      GridPane.setConstraints(text, 0, 7, 1, 3);
      
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
         if ((nameIn.getText() == null) || (nameIn.getText().isEmpty())){//no name
            PopUpWindow nameRemind = new PopUpWindow  ("even the bravest of adventurers needs a name", "continue");
            return;
         }else if (points.getValue() != 0){//not all tokens used
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
                     text.appendText("+" + points.getValue() + " coins\n\n"); 
                     showAttributesSwitchScreen(primaryStage);
                  }else if (tokensRemind2.getButton() == false){
                     notSpent++;
                     PopUpWindow noImNotSure = new PopUpWindow("please just hurry up. i want to go home", "continue");
                  }
            }else if (notSpent >= 3){
               PopUpWindow bye = new PopUpWindow("yeah... i'm just 'gonna kick you out", "bye");
               primaryStage.close();
            }
         }
       if ((nameIn != null) && (points.getValue() == 0)){//everything is filled out
         showAttributesSwitchScreen(primaryStage);
       }
      });
   }//main
   
   
   public void secondScene(CharacterStats stats, TextArea text){
      GridPane.setConstraints(text, 0, 13);
      
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
         GridPane.setConstraints(submit, 0, 12);
         
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
                  text.appendText("\n+10 luck\n");
                  text.appendText("+5 speed\n");
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == wHat){
                  stats.incrementStats(1, 10, 0, 5);
                  text.appendText("\n+10 cunning\n");
                  text.appendText("+5 strength\n");
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == scarf){
                  stats.incrementStats(4, 10, 1, 5);
                  text.appendText("\n+10 memory\n");
                  text.appendText("+5 cunning\n");
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == sHat){
                  stats.incrementStats(3, 10, 4, 5);
                  text.appendText("\n+10 speed\n");
                  text.appendText("+5 memory\n");
                  //stats.equipItem(____);
               }else if (buttons.getSelectedToggle() == hands){
                  stats.incrementStats(0, 15, 0, 0);
                  text.appendText("\n+15 strength\n");
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
      
      //top label
      //HBox box = new HBox();
      Label label = new Label("name of room");
         //box.getChildren().add(label);
         GridPane.setConstraints(label, 2, 0);
         GridPane.setHalignment(label, HPos.CENTER);
      
      //buttons
      Button explore = new Button("EXPLORE");
         GridPane.setConstraints(explore, 2, 1);
         explore.setPrefSize(210, 15);
         explore.setAlignment(Pos.CENTER);
      Button statsBtn = new Button("stats");
         statsBtn.setPrefSize(90, 15);
      Button items = new Button("items");
         items.setPrefSize(90, 15);
      Button build = new Button("build");
         build.setPrefSize(90, 15);
      
      //stack buttons
      HBox btns1 = new HBox(20);
         GridPane.setConstraints(btns1, 2, 2);
         btns1.getChildren().addAll(statsBtn, items);
         btns1.setAlignment(Pos.CENTER);
      HBox btns2 = new HBox(20);
         GridPane.setConstraints(btns2, 2, 3);
         btns2.getChildren().addAll(build);
      
      //grid setup
      GridPane grid = new GridPane();
      grid.setVgap(15);
      grid.setHgap(20);
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.getChildren().addAll(label, explore, btns1, btns2);
      
      //text output
      grid.add(text, 0, 13, 6, 8);
      
      //window setup
      Scene scene = new Scene(grid, 320, 420);
      Stage mainStage = new Stage();
      mainStage.setScene(scene);
      mainStage.setResizable(false);
      mainStage.setTitle("Title of Game");
      mainStage.show();
      
      //button actions
      statsBtn.setOnAction(e -> {
         stat(stats, text);
         mainStage.hide();
      });
      items.setOnAction(e -> {
         items();
         mainStage.hide();
      });
      
   /* explore.setOnAction(e -> {
         //map(stats, text);
         mainStage.hide();
      });
      build.setOnAction(e -> {
         //backpack(stats, text);
         mainStage.hide();
      });  */
      
   }//main screen
   
   
   public void stat(CharacterStats stats, TextArea text){
      
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
      GridPane.setConstraints(coins, 0, 11);
      
      //text output
      //grid.add(text, 0, 13, 2, 6);
      
      //window setup
      grid.getChildren().addAll(top, name, strength.getBox(), cunning.getBox(), luck.getBox(), speed.getBox(), memory.getBox(), coins);
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
   

   public void items(){
      
      //layout setup
      BorderPane layout = new BorderPane();
      
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      
      Button back = new Button("<back");
      Label label = new Label("a small wooden box");
      HBox box = new HBox(55);
      box.getChildren().addAll(back, label);
      grid.getChildren().add(box);
      
      layout.setTop(grid);
      layout.setCenter(inventory.showList());
      
      //window setup
      Scene scene = new Scene(layout, 320, 420);
      Stage itemsStage = new Stage();
      itemsStage.setResizable(false);
      itemsStage.setScene(scene);
      itemsStage.setTitle("Title of Game");
      itemsStage.show();
      
      //button actions
      back.setOnAction(e -> {
         mainScreen(stats, text);
         itemsStage.hide();
      });
   }//items
   
   
/*
   public void backpack(){
   }//backpack
   
   public void map(){
   }//map
*/
   
   
   private void showAttributesSwitchScreen(Stage primaryStage){
      stats.newStats(strength.getValue(), cunning.getValue(), luck.getValue(), speed.getValue(), memory.getValue(), nameIn.getText());
      secondScene(stats, text);
      primaryStage.hide();
      
      if(strength.getValue() != 0){
            //sleep(500);
            text.appendText("+" + strength.getValue() + " strength\n");//prints out to scrolable text area
      }if(cunning.getValue() != 0){
            text.appendText("+" + cunning.getValue() + " cunning\n");
      }if(luck.getValue() != 0){
            text.appendText("+" + luck.getValue() + " luck\n");
      }if(speed.getValue() != 0){
            text.appendText("+" + speed.getValue() + " speed\n");
      }if(memory.getValue() != 0){
            text.appendText("+" + memory.getValue() + " memory\n");
      } 
   }

   /*
   private static void sleep(int ms){
      try{
       Thread.sleep(ms);
      }catch(InterruptedException e){ }
   }*/
}//class