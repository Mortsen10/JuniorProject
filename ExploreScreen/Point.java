// Point holds the x and y values (combines the x and y values into a Point)
// 
// this class is immutable, kind of like String in Java. That is, there is 
// no way to modify an existing Point's values. Rather, you would use the
// translate method which returns a *new* instance with *new* values
public class Point{
   private final int x; //immutible values (final = cannot be changed)
   private final int y;
   
   public Point(int x, int y){
      this.x = x;
      this.y = y;
   }
   
   public int getX(){
      return this.x;
   }
   
   public int getY(){
      return this.y;
   }
   
   public Point translate(int dx, int dy){
      return new Point(this.x + dx, this.y + dy);
   }
}