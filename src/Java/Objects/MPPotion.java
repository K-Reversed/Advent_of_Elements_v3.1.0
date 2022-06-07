package Java.Objects;

public class MPPotion extends GameObjects {
   public MPPotion () {
       setName("Magic Potion");
       setImage("/Magic Potion.png");
   }

   public String toString() {
       return getName();
   }
}
