import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.lang.Character;
import java.util.Iterator;
import java.util.List;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {


       FoodRatings fr = new FoodRatings(
               new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
               new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9,12,8,15,14,7});

        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("sushi",16);
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("ramen",16);
        System.out.println(fr.highestRated("japanese"));


    }



}
