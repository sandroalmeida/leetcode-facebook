package info.sandroalmeida;

public class ValidPalindromic {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        while(left <= right){
            char charL = chars[left];
            char charR = chars[right];

            if((charL < 'a' || charL > 'z') && !Character.isDigit(charL)) {
                left++;
                continue;
            }
            if((charR < 'a' || charR > 'z') && !Character.isDigit(charR)) {
                right--;
                continue;
            }
            if(charL != charR)
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
