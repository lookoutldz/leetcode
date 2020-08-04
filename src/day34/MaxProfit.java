package day34;

public class MaxProfit {

    // 傻瓜式
    public int maxProfit(int[] prices) {
        int max = 0, len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    // 递归
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - mixPrice(prices, i-1));
        }
        return max;
    }

    // 前 i 天内最小值，含 i
    private int mixPrice(int[] prices, int i) {
        if (i == 0) {
            return prices[0];
        }
        return Math.min(mixPrice(prices, i-1), prices[i]);
    }

    // 普通动态规划
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public void test() {
        int[] a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit3(a));
    }
}
