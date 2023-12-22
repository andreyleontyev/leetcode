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


        System.out.println(maxScore("011101"));

    }


    public static int maxScore(String s) {
        int countZerosLeft = 0;
        int countOnesRight = 0;
        int maxScore = 0;

        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '1') countOnesRight ++;
        }

        for (int i = 0; i< s.length()-1; i++) {
            if (s.charAt(i) == '1') {
                countOnesRight--;
            }
            else {
                countZerosLeft++;
            }

            maxScore = Math.max(maxScore, countZerosLeft + countOnesRight);
        }
        return maxScore;
    }

}
