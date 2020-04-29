package day5;

public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        long reverse = 0;
        int backup = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return (int)reverse == backup;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int index = 1;
        while (x % Math.pow(10, index) != x) {
            index++;
        }
        int[] nums = new int[index];
        for (int i = 0; i < index; i++) {
            nums[i] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < index; i++) {
            if (nums[i] != nums[index - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        System.out.println(isPalindrome(12388321));
    }
}
