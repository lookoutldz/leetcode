package day4;

public class IntReverse {

    public int reverse(int x) {
        long n = 0;
        for (; x != 0; n = n * 10 + x % 10, x /= 10) {
        }
        return (int)n == n? (int)n : 0;
    }

    public void test() {
        System.out.println(reverse(123));
    }
}
