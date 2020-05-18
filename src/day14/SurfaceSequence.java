package day14;

public class SurfaceSequence {
    public String countAndSay(int n) {
        if (n < 2) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "11";
        for (int i = 2; i < n; i++) {
            s = countXn(s);
        }
        return s;
    }

    private String countXn(String s) {
        int n = 0;
        char a, b;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i-1) != s.charAt(i)) {
                a = (char)(i - n + 48);
                b = s.charAt(i-1);
                n = i;
                sb.insert(0, b).insert(1, a);
            } else {
                if (i == s.length()) {
                    a = (char)(i - n + 48);
                    b = s.charAt(i-1);
                    sb.insert(0, b).insert(1, a);
                    return sb.reverse().toString();
                }
            }
        }
        return sb.reverse().toString();
    }

    public void test() {
        System.out.println(countAndSay(6));
    }
}
