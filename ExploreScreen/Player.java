//data item (part of the model)
public class Player{
   private static final int SIZE = 10; //size of the player
   private final BoundedPoint position; //initial position of the player
   
   public Player(){
      this.position = new BoundedPoint();
   }
   
   public boolean move(int dx, int dy){
      return this.position.move(dx, dy); // ??
   }
   
   public Point getPosition(){
      return this.position.getPoint(); // ??
   }
}