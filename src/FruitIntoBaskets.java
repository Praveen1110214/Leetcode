import java.util.*;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit2(fruits));
    }
    static int totalFruit(int[] fruits){
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < fruits.length; j++){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() == 3){
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
    static  int totalFruit2(int[] fruits){
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j < fruits.length; j++){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2){
                int leftFruit = fruits[i];
                int freq = map.get(leftFruit)-1;
                if(freq == 0) map.remove(leftFruit);
                else map.put(leftFruit, freq);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
