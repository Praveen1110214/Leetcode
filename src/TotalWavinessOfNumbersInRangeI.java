public class TotalWavinessOfNumbersInRangeI {
    public static void main(String[] args) {
        int num1 = 120;
        int num2 = 130;
        System.out.println(totalWaviness1(num1, num2));
    }
    static int totalWaviness(int num1, int num2){
        int totalWaviness = 0;
        for(int i = num1; i <= num2; i++){
            String currentNum = String.valueOf(i);
            if(currentNum.length() >= 3){
                for(int j = 1; j < currentNum.length() - 1; j++){
                    int curr = currentNum.charAt(j);
                    int prev = currentNum.charAt(j - 1);
                    int next = currentNum.charAt(j + 1);
                    if(curr < prev && curr < next){
                        totalWaviness++;
                    } else if(curr > prev && curr > next){
                        totalWaviness++;
                    }
                }
            }
        }
        return  totalWaviness;
    }
    static int totalWaviness1(int num1, int num2){
        int totalWaviness = 0;
        for(int i = num1; i <= num2; i++){
            if(i < 100) continue;
            totalWaviness += totalWavinessHelper(i);
        }
        return totalWaviness;
    }
    static int totalWavinessHelper(int num){
        int totalWaviness = 0;
        int next = num % 10;
        num /= 10;
        int curr = num % 10;
        num /= 10;
        while(num > 0){
            int prev = num % 10;
            if((curr > prev && curr > next) || (curr < prev && curr < next)) totalWaviness++;
            next = curr;
            curr = prev;
            num /= 10;
        }
        return totalWaviness;
    }
}
