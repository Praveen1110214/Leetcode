public class DetectCapitals {
    public static void main(String[] args) {
        String word = "LeetcodE";
        System.out.println(detectCapitalUsers(word));
    }
    static boolean detectCapitalUsers(String word){
        int count = 0;
        for(char character : word.toCharArray()){
            if(Character.isUpperCase(character)){
                count++;
            }
        }
        return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
