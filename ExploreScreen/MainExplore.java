// set up the "MVC" components and display
// the primary stage (main window)

import javafx.application.*;
import javafx.stage.*;

public class MainExplore extends Application{
   private final String title = "title";
   
   @Ovveride
   public void start(Stage primaryStage){
   
      primaryStage.setTitle(title);

        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(primaryStage, controller, model);
        
        primaryStage.show();
   }
   
}