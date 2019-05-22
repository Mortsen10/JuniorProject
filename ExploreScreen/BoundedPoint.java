// a Point with defined boundaries 
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
   
   public Point getPoint(){
      return this.current();
   }
   
   // Attempts to move the point by the given delta. The method first checks
   // whether the new point would be in bounds. If so, it will set the current
   // point to the new point and return true. Otherwise, it makes no changes
   // and returns false
   public boolean move(int dx, int dy){
      Point newPoint = this.current.translate(dx, dy);
      if((newPoint.getX() <= this.max.getX()) &&
         (newPoint.getX() >= this.min.getX()) &&
         (newPoint.getY() <= this.max.getY()) &&
         (newPoint.getY() >= this.min.getY()){
         return true;
      }else{
         return false;  
      }
   }
}