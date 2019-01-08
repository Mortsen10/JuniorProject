import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;//Insets

public class CharacterSetup extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      Label atrName = new Label("strength");                 // simplify all into one Node I can make by declaring and initializing
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
      nameIn.setPromptText("sasha");//default text (will be greyed out)
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
