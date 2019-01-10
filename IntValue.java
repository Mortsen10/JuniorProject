import javafx.beans.property.*;

public class IntValue{

   private int   value;
   private final String name;
   private final SimpleIntegerProperty prop;
   
   public IntValue(String name){
      this.name = name;
      this.prop = new SimpleIntegerProperty();
   }

   public void increment(){
      this.value++;
      this.prop.set(this.value);
   }
   
   public void decrement(){
      this.value--;
      this.prop.set(this.value);
   }
   
   public SimpleIntegerProperty getProperty(){
      return prop;
   }

}//class