import javafx.beans.property.*;

public class IntValue{

   private int   atrValue;
   private final String name;
   private final SimpleIntegerProperty atrPtsLabel;
   
   public IntValue(String name){//constructor
      this.name = name;
      this.atrPtsLabel = new SimpleIntegerProperty();
   }

   public void increment(){
      this.atrValue++;
      this.atrPtsLabel.set(this.atrValue);
      //distPts.increment();
   }
   
   public void decrement(){
      this.atrValue--;
      this.atrPtsLabel.set(this.atrValue);
      //distPts.decrement();
      
   }
   
   public SimpleIntegerProperty getAtrProperty(){
      return atrPtsLabel;
   }

}//class