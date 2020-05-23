package day18;

public class BinarySum {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int len = a.length(), offset = a.length() - b.length();
        char enter = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (i >= offset) {
                switch (a.charAt(i) + b.charAt(i - offset) + enter) {
                    case 144:
                        enter = '0';
                        sb.insert(0, '0');
                        break;
                    case 145:
                        enter = '0';
                        sb.insert(0, '1');
                        break;
                    case 146:
                        enter = '1';
                        sb.insert(0, '0');
                        if (i == 0) {
                            sb.insert(0, '1');
                            return sb.toString();
                        }
                        break;
                    case 147:
                        enter = '1';
                        sb.insert(0, '1');
                        if (i == 0) {
                            sb.insert(0, '1');
                            return sb.toString();
                        }
                        break;
                    default:
                        break;
                }
            } else {
                switch (a.charAt(i) + enter) {
                    case 96:
                        enter = '0';
                        sb.insert(0, '0');
                        break;
                    case 97:
                        enter = '0';
                        sb.insert(0, '1');
                        break;
                    case 98:
                        enter = '1';
                        sb.insert(0, '0');
                        if (i == 0) {
                            sb.insert(0, '1');
                            return sb.toString();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return sb.toString();
    }

    public void test() {
        System.out.println(addBinary("11", "1"));
    }
}
