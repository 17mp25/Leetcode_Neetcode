package practiceproblems.arrays;

public class MaxProfit {
    public static int max(int[] price) {
        int maxprofit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int currentPrice : price) {
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
            maxprofit = Math.max(maxprofit, currentPrice - minPrice);
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println(max(price)); // Output: 5 (buy at 1 and sell at 6)
    }
}
