// Represents all of the data in the application
// A model ideally knows nothing about the user interface (that knowledge is instead with the view)
// It does not decide when to make updates to the data (that is the controller's job)
//
// The model also contains events to notify the view that its state has changed
// In this case, however, we just provide a simple getter method which we expect 
// the view to query when it wants to

public class ModelExplore{
   private final Player player; //data item
   
   //constructor
   public ModelExplore(){
      this.player = new Player();
   }
   
   //getter
   public Player getPlayer(){
      return this.player;
   }
}