package Java.Objects;

import Java.Main.GUI;

public class MPPotion extends GameObjects {
   public MPPotion (GUI gPanel) {
       super(gPanel);
       setName("Magic Potion");
       setImage("/Magic Potion.png");
   }

   public String toString() {
       return getName();
   }
}
