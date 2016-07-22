package leetcode.Dynamic;

/**
 * Created by lishiwei on 16/7/22.
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (
ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
 */
/*
递推公式 res = arr[i] - min(i-1)
 */ /*
    Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
     */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > res)
                res = prices[i] - min;
            if (min > prices[i])
                min = prices[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(arr));
    }
}
