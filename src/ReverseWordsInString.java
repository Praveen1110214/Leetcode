public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWordsTwoPointers(s));
    }
    static String reverseWords(String s){
        String str = s.strip();
        String[] arr = str.split("\\s+");
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            if(i > 0){
                string.append(" ");
            }
            string.append(arr[i]);
        }
        return string.toString();
    }
    static String reverseWordsTwoPointers(String s){
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0) break;
            int end = i;
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            String word = s.substring(i + 1, end + 1);
            if(!sb.isEmpty()) sb.append(" ");
            sb.append(word);
        }
        return sb.toString();
    }
}
