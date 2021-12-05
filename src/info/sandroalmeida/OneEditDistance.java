package info.sandroalmeida;

public class OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        int diff = Math.abs(s.length() - t.length());
        if(diff >= 2)
            return false;

        int minLength = Math.min(s.length(), t.length());
        boolean isFirstDiff = true;
        int p1, p2 = 0;
        for(p1 = 0; p1 < minLength; p1++){
            if(s.charAt(p1) != t.charAt(p2))
                if(s.length() == t.length()){
                    if(isFirstDiff){
                        isFirstDiff = false;
                        continue;
                    } else{
                        return false;
                    }
                } else{
                    if(isFirstDiff){
                        isFirstDiff = false;
                        p2++;
                    }
                }
            p2++;
        }
       return true;
    }

    public static void main(String[] args) {
        String s = "ab", t = "acb";
        System.out.println(isOneEditDistance(s, t));
    }
}
