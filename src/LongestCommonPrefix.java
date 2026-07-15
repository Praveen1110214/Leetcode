import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 4, 4};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
    static int longestCommonPrefix(int[] arr1, int[] arr2){
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : arr1){
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }
        for(int num : arr2){
            while(num > 0){
                if(set.contains(num)){
                    ans = Math.max(ans, String.valueOf(num).length());
                }
                num /= 10;
            }

        }
        return ans;
    }
}
