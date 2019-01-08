import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;//Insets

public class CharacterSetup extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      Label atrName = new Label("Strength");                 // simplify all into one Node I can make by declaring and initializing
      atrName.setPrefSize(50, 20);
      
      Label label = new Label("0");
      label.setPrefSize(50, 20);
      
      Button plus = new Button("+");
      plus.setPrefSize(25, 10);
      
      Button minus = new Button("-");
      minus.setPrefSize(25, 20);
      
      HBox strength = new HBox(30);
      strength.getChildren().addAll(atrName, label, plus, minus);
      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(15);
      grid.setHgap(10);
      
      Label out = new Label("welcome. select your character attributes. but be careful,\nthese cannot be changed later on.");
      GridPane.setConstraints(out, 0, 0);
      
      Label name = new Label("name:");
      TextField nameIn = new TextField();//lets users type an input
      nameIn.setPromptText("sasha");//can put default text in quotes (will be greyed out)
      HBox naming = new HBox(5);
      naming.getChildren().addAll(name, nameIn);
      GridPane.setConstraints(naming, 0, 1);
      
      //make attribute Nodes
      GridPane.setConstraints(strength, 0, 2);
      
      Button submit = new Button("submit");
      GridPane.setConstraints(submit, 0, 7);
      
      grid.getChildren().addAll(out, naming, strength, submit);
      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      Scene scene = new Scene(grid, 320, 400);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
      
      plus.setOnAction(e -> label.setText("plus"));
      minus.setOnAction(e -> label.setText("minus"));
    //submit.setOnAction(e -> ); // switch to next scene
      
   }//main
   
}//class

/*
      Label atrName = new Label(this.attribute);
      atrName.setPrefSize(60,20);
      
      Label label = new Label("0");
      label.setPrefSize(30, 20);
      
      Button plus = new Button("+");
      plus.setPrefSize(25, 10);
      
      Button minus = new Button("-");
      minus.setPrefSize(25, 20);
           
      HBox attribute = new HBox(15, atrName, label, plus, minus);
*/

/*            
      Attribute strength = new Attribute("Strength"); //returns HBox??

      Attribute cunning = new Attribute("Cunning");
      Attribute luck = new Attribute("Luck");
      Attribute speed = new Attribute("Speed");
      Attribute memory = new Attribute("Memory");
      
      GridPane layout = new GridPane();
      layout.setPadding(new Insets(10, 10, 10, 10)); //gives the whole grid some spacing
      GridPane.setContraints(strength, 0,0);// sets to first collumn, first row
      //add the rest
      
      layout.getChildren().addAll(strength, cunning, luck, speed, memory);//NEEDS NODES, NOT ATTRIBUTES
*/
