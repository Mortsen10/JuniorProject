import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CharacterSetup extends Application{  //WHEN BUTTON IS PRESSED, SAY "PLUS" or "MINUS"

   @Override
   public void start(Stage primaryStage) throws Exception{
      
      Button plus = new Button("+");
      Button minus = new Button("--");
      Label label = new Label("0");
      HBox botmRow = new HBox(15, label, plus, minus);
      Label atrName = new Label("Strength");
      VBox attribute = new VBox(5, atrName, botmRow);
      
      Scene scene = new Scene(attribute, 600, 400);
      
      primaryStage.setScene(scene);
      primaryStage.setTitle("Title of Game");
      primaryStage.show();
      
      plus.setOnAction(e -> label.setText("plus"));
      minus.setOnAction(e -> label.setText("minus"));
      
   }
   
   
   
}