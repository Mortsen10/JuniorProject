import javafx.beans.property.*;

public class DistPtsValue{
   
   private int   distPtsValue = 10;
   private final SimpleIntegerProperty distPtsLabel; //all attributes might not share the same distPts (FIX)

   public DistPtsValue(){
      this.distPtsLabel = new SimpleIntegerProperty();
   }
   
   public SimpleIntegerProperty getDistProperty(){ //constructor
      return distPtsLabel;
   }
   
   public void decrement(){
      distPtsValue--;
      this.distPtsLabel.set(this.distPtsValue);
   }
   
   public void increment(){
      distPtsValue++;
      this.distPtsLabel.set(this.distPtsValue);
   }

}//class