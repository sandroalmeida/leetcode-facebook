package info.sandroalmeida;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if(num1.equals("") || num2.equals(""))
            return "0";

        int[] result = new int[num1.length() + num2.length()];

        StringBuilder sb = new StringBuilder(num1);
        String rNum1 = sb.reverse().toString();
        sb = new StringBuilder(num2);
        String rNum2 = sb.reverse().toString();

        for(int i = 0; i < rNum1.length(); i++){
            for(int j = 0; j < rNum2.length(); j++){
                int digit1 = Integer.parseInt(rNum1.charAt(i) + "");
                int digit2 = Integer.parseInt(rNum2.charAt(j) + "");
                result[i + j] += digit1 *  digit2;
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] = result[i + j] % 10;
            }
        }

        sb = new StringBuilder();
        for(int i = result.length - 1; i >= 0; i--){
            if(sb.length() == 0 && result[i] == 0)
                continue;
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //Input: num1 = "123", num2 = "456"
        //Output: "56088"
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
