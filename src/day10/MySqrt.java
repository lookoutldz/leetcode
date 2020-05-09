package day10;

public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        for (int i = 1; i <= x; i++) {
            if (x / i < i) {
                return i - 1;
            }
        }
        return (int) Math.sqrt(x);
    }

    public void test() {
        System.out.println(mySqrt(2));
    }
}
