import java.util.Arrays;

public class StockBuyAndSell {
	/********************************************
	 * Best Time to Buy and Sell Stock I: Naive O(N^2)
	 ********************************************/
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > maxProfit) {
					maxProfit = prices[j] - prices[i];
				}
			}
		}
		return maxProfit;
	}

	/*******************************************
	 * Best Time to Buy and Sell Stock I: Traverse through the array, keep track
	 * of two things: 1. maximum profit so far 2. minimum element so far update
	 * minimum at every iteration update profit if it needs updating.
	 *******************************************/
	public static int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int minPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
			if (prices[i] < minPrice)
				minPrice = prices[i];

		}
		return maxProfit;
	}

	/*****************************************
	 * Best Time to Buy and Sell Stock II: You may complete as many transactions
	 * as you like:
	 * 
	 * This problem can be viewed as finding all ascending sequences.
	 ******************************************/
	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int totalProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			int j = i;
			while (i < prices.length - 1 && prices[i] < prices[i + 1])
				i++;
			if (i != j)
				totalProfit += prices[i] - prices[j];
		}

		return totalProfit;
	}

	public static void main(String[] args) {
		// int[] prices = { 100, 180, 160, 310, 40, 535, 695 };
		int[] prices = { 6, 1, 3, 2, 4, 7 };
		System.out.println(maxProfit3(prices));
	}
}
