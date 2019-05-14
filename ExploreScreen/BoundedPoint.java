// a point with defined boundaries
// The point is not allowed to move left of or above the min, nor can it move right of or below the max 
//    ------- x 
//    |  --> (pos)
//    |  |
//    |  v
//   y  (pos)

public class BoundedPoint{
   private final Point min; //min and max boundaries 
   private final Point max; //   (immutable fields)

   private Point current; //can be changed and can be updated by the move method
   
   public BoundedPoint(int minX, int minY, int maxX, int maxY){
      this.min = new Point(minX, minY);
      this.max = new Point(maxX, maxY);
      this.current = this.min; //sets starting point to upper left hand corner -------------------------------------------// change later
   }
}