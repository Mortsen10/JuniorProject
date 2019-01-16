import javafx.beans.property.*;

public class AttributeValue implements IntValue{

   private int   atrValue;
   private final String name;
   private final SimpleIntegerProperty atrPtsLabel;
   private final IntValue parent;//is null
   
   public AttributeValue(String name, IntValue parent){//constructor
      this.name = name;
      this.atrPtsLabel = new SimpleIntegerProperty();
      this.parent = parent;
   }

   public boolean increment(){
      if (this.parent == null || this.parent.decrement()){//decrementing the parent (10 distPts), not the actual value
         this.atrValue++;
         this.atrPtsLabel.set(this.atrValue);
         return true;
      }else{
         return false;
      }
   }
   
   public boolean decrement(){
      if (this.atrValue > 0 && (this.parent == null || this.parent.increment())){
         this.atrValue--;
         this.atrPtsLabel.set(this.atrValue);
         return true;
      }else{
         return false;
      }
   }
  
   public SimpleIntegerProperty getAtrProperty(){
      return atrPtsLabel;
   }

}//class