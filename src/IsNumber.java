public class IsNumber {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(isNumber(s));
    }
    public static boolean isNumber(String s) {
        int length = s.length();
        int index = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        if (index == length) {
            return false;
        }
        if (s.charAt(index) == '.' &&
                (index + 1 == length || s.charAt(index + 1) == 'e' || s.charAt(index + 1) == 'E')) {
            return false;
        }
        int decimalCount = 0;
        int exponentCount = 0;
        for (int currentIndex = index; currentIndex < length; currentIndex++) {
            char currentChar = s.charAt(currentIndex);
            if (currentChar == '.') {
                if (exponentCount > 0 || decimalCount > 0) {
                    return false;
                }
                decimalCount++;
            } else if (currentChar == 'e' || currentChar == 'E') {
                if (exponentCount > 0 || currentIndex == index || currentIndex == length - 1) {
                    return false;
                }
                exponentCount++;
                if (s.charAt(currentIndex + 1) == '+' || s.charAt(currentIndex + 1) == '-') {
                    currentIndex++;
                    if (currentIndex == length - 1) {
                        return false;
                    }
                }
            } else if (currentChar < '0' || currentChar > '9') {
                return false;
            }
        }
        return true;
    }
}
