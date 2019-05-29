import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.stage.*;

// main visual elements in the application
// 
// the view interacts with the controller when user input is received, 
//    and shows any updates from the data model on the screen
// 
// the view should contain as little "business logic" as possible
//    (that info is better handled by the controller and model)

public class ViewExplore{
   private static final int WIDTH = 600;
   private static final int HEIGHT = 400;
   
   private final GraphicsContext graphics;
   private final Model           model;       // ask for data 
   private final Controller      controller;  // send commands
   
   // Instantiates the view by setting up all the UI elements and hooking up
   // the model and controller interactions
   public ViewExplore(Stage stage, MyController controller, MyModel model){
      Canvas canvas = new Canvas(WIDTH, HEIGHT);
      Group group = new Group();
      group.getChildren().add(canvas);
      
      Scene scene = new Scene(group, WIDTH, HEIGHT);
      
      this.graphics = new getGraphicsContext2D();
      this.model = model;
      this.controller = controller;
      
      this.refresh(); //refresh at the beginning to show setup (otherwise would wait for a user click)
      
      // set up the UI events
      //
      // We need to request focus in order for key press events to be handled by the Canvas
      //    The term "focus" is used a lot in UI programming and refers to which UI element 
      //    is considered "active"
      //
      // A Canvas (unlike, say, a Button or TextField) is not usually
      // considered a "focusable" UI element, and key events are only sent to
      // "the node that has focus"
      canvas.requestFocus();
      canvas.setOnKeyPressed(e -> this.onKeyPressed(e));
   }
   
   private void onKeyPressed(KeyEvent e){
      boolean handled = this.handleKeyPress(e.getCode()); //event.get which key is pressed (KeyCode)
      if(handled){ //if key event is valid and taken care of, update the UI
         this.refresh();
      }
   }
   
   // Handles the key press
   // If we understand the key, we will ask the controller to do the action associated with that key
   //    this is called "dispatching," 
   //
   // and is much like how a transportation dispatcher might give instructions to a 
   // truck driver on what route they should be taking. The dispatcher is not 
   // interested in the details -- in the case of this application it simply needs 
   // to be told "yes, I'll do it" (boolean `true` value) or "no, that can't be done" 
   // (boolean `false` value)
   private boolean handleKeyPress(KeyCode code){
      switch(code){
         case UP:
            return this.controller.moveUp();
         case DOWN:
            return this.controller.moveDown();
         case LEFT:
            return this.controller.moveLeft();
         case RIGHT:
            return this.controller.moveRight();
         default: //we don't understand any more key actions
            return false;
      }
   }
   
   private void refresh(){
      this.graphics.setFill(Color.GREY); //sets color
      this.graphics.fillRect(0, 0, WIDTH, HEIGHT); //draws a rectangle on the screen in the color set (starts in the top left corner)
      this.drawPlayer();
   }
   
   private void drawPlayer(){
      this.graphics.setFill(Color.BLACK);
      Player player = this.model.getPlayer();
      Point p = player.getPosition();
      int size = player.getSize();
      this.graphics.fillRect(p.getX(), p.getY(), size, size);
   }
}