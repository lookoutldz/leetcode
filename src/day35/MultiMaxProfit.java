package day35;

public class MultiMaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = 0, sum = 0;
        boolean hasBuy = false;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1] && hasBuy) {
                sum += prices[i] - buy;
                hasBuy = false;
            }
            if (i < prices.length - 1 && prices[i] < prices[i + 1] && !hasBuy) {
                buy = prices[i];
                hasBuy = true;
            }
        }
        return sum;
    }

    public void test() {
        int[] a = new int[]{1,7,1,5,3,6,8};
        System.out.println(maxProfit(a));
    }
}
