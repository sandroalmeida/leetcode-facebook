package info.sandroalmeida;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        StringBuilder aux = new StringBuilder(a);
        String reverseA = aux.reverse().toString();
        aux = new StringBuilder(b);
        String reverseB = aux.reverse().toString();

        int maxLength = Math.max(reverseA.length(), reverseB.length());
        int carry = 0;
        for(int i = 0; i < maxLength; i ++){
            int digitA = i < reverseA.length() ? Integer.parseInt(reverseA.charAt(i) + "") : 0;
            int digitB = i < reverseB.length() ? Integer.parseInt(reverseB.charAt(i) + "") : 0;
            int total = digitA + digitB + carry;
            result.append(total % 2);
            carry = total / 2;
        }
        if(carry != 0) result.append(carry);

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1", b = "11";
        System.out.println(addBinary(a, b));
    }
}
