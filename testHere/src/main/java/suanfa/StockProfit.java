package suanfa;

public class StockProfit {

    public static int maxProfitFor1Time(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 最小值
        int minPrice = prices[0];
        // 最大收益
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {9, 2, 7, 4, 3, 1, 8, 4};
        System.out.println(maxProfitFor1Time(prices));
    }

}