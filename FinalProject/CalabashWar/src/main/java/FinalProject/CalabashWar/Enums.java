package FinalProject.CalabashWar;

import java.util.*;

//Randomly select a value in an enum
public class Enums {
    public static Random r = new Random();
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[r.nextInt(values.length)];
    }
}
