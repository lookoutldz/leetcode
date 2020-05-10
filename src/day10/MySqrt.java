package day10;

public class MySqrt {

    /**
     * 无脑穷举
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        for (int i = 1; i <= x; i++) {
            if (x / i < i) {
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * 牛顿迭代法求平方根：
     * 牛顿迭代式：r ≈ x[n+1] = x[n] - f(x[n]) / f'(x[n])
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        double xn = x, r = x-1;
        while (xn - r > 0.9) {
            xn = r;
            r =  0.5 * (xn + x / xn);
        }
        return (int) r;
    }

    /**
     * 递归版牛顿迭代
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        if (x <= 1) {
            return x;
        }
        double xn = x, r = x-1;
        return (int) recursive(xn, r, x);
    }

    public double recursive(double xn, double r, int x) {
        xn = r;
        r =  0.5 * (xn + x / xn);
        if (xn - r > 0.9) {
            r = recursive(xn, r, x);
        }
        return r;
    }

    public void test() {
        System.out.println(mySqrt3(122));
    }
}
