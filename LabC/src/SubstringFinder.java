import java.util.HashMap;
import java.util.Map;

// 
public class SubstringFinder {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Please provide n and S as arguments.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String S = args[1];

        System.out.println(findCommonSub(n, S));
    }

    public static String findCommonSub(int n, String S) {
        Map<String, Integer> freqMap = new HashMap<>();
        String commonSub = "";
        int maxFreq = 0;

        for (int i = 0; i <= S.length() - n; i++) {
            String currSub = S.substring(i, i + n);
            freqMap.put(currSub, freqMap.getOrDefault(currSub, 0) + 1);

            if (freqMap.get(currSub) > maxFreq) {
                maxFreq = freqMap.get(currSub);
                commonSub = currSub;
            } else if (freqMap.get(currSub) == maxFreq) {
                commonSub = lexSmaller(commonSub, currSub);
            }
        }

        return commonSub;
    }

    public static String lexSmaller(String s1, String s2) {
        String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s1.length(); i++) {
            if (order.indexOf(s1.charAt(i)) < order.indexOf(s2.charAt(i))) {
                return s1;
            } else if (order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i))) {
                return s2;
            }
        }
        return s1;  // both strings are equal
    }
}
