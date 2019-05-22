// Represents all of the user interactions in the application
// The controller interacts with the model, usually when told to do so due to an "event" (such as a key press or mouse movement)
//
// A controller does not know how the user interface is implemented
// It is the view's responsibility to tell the controller that an event happened 
//    (in a way that the controller will understand)
//    (so you will not see any code relating to key presses or anything like that) 
// The controller provides "commands" that the view should invoke given specific user input
// 
//    ------- x 
//    |  --> (pos)
//    |  |
//    |  v
//   y  (pos)

public ControlerExplore{
   // class constatant for the delta value of each movement
   public static final int DELTA = 2; //number of pixels
   
   private final Model model; //will refresh
   
   public ControlerExplore(Model model){
      this.model = model;
   }
   
   public boolean moveUp(){
      return this.model.getPlayer().move(0, -DELTA);
   }
   
   public boolean moveDown(){
      return this.model.getPlayer().move(0, DELTA);
   }
   
   public boolean moveLeft(){
      return this.model.getPlayer().move(-DELTA, 0);
   }
   
   public boolean moveRight(){
      return this.model.getPlayer().move(DELTA, 0);
   }
}