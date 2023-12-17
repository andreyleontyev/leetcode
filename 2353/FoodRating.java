import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodRatings {

    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisinesFoodRating= new HashMap();
    HashMap<String,String> foodToCuisine= new HashMap<>();
    HashMap<String,Integer> foodToRating= new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisinesFoodRating = new HashMap();
        TreeSet<String> foodsTreeSet;
        TreeMap<Integer, TreeSet<String>> ratingsTreeMap;
        foodToCuisine = new HashMap<>();
        foodToRating =new HashMap<String,Integer>();

        for (int i = 0; i < foods.length ; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);

            ratingsTreeMap = cuisinesFoodRating.get(cuisines[i]);
            if (ratingsTreeMap == null) {
                ratingsTreeMap = new TreeMap<Integer, TreeSet<String>>();
                cuisinesFoodRating.put(cuisines[i], ratingsTreeMap);
            }

            foodsTreeSet = ratingsTreeMap.get(ratings[i]);
            if (foodsTreeSet == null) {
                foodsTreeSet = new TreeSet<String>();
                ratingsTreeMap.put(ratings[i], foodsTreeSet);
            }

            foodsTreeSet.add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        TreeMap<Integer, TreeSet<String>> ratingsTreeMap = null;
        TreeSet<String> foodsTreeSet;

        ratingsTreeMap = cuisinesFoodRating.get(foodToCuisine.get(food));
        //remove from the previous
        ratingsTreeMap.get(foodToRating.get(food)).remove(food);
        if (ratingsTreeMap.get(foodToRating.get(food)).size() == 0) {
            ratingsTreeMap.remove(foodToRating.get(food));
        }

        //add to the new structure
        foodsTreeSet = ratingsTreeMap.get(newRating);
        if (foodsTreeSet == null) {
            foodsTreeSet = new TreeSet<String>();
            ratingsTreeMap.put(newRating, foodsTreeSet);
        }
        foodsTreeSet.add(food);
        foodToRating.put(food,newRating);

    }

    public String highestRated(String cuisine) {
        return cuisinesFoodRating.get(cuisine).firstEntry().getValue().getFirst();
    }
}
