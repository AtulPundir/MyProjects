package com.ap.pre.leetcode;

//EASY
//Only one time buy and one time selling is allowed
public class BestTimetoBuyAndSellStock121 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
        for (int j = i+1; j < prices.length ; j++){

            if (prices[j] > prices[i]) {
                int profit = prices[j] - prices[i];
                maxProfit = profit > maxProfit ? profit: maxProfit;
            }
        }
    }
    return maxProfit;
        
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int diff = 0;
    
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; 
            } else {
                diff = price - minPrice;
               // maxProfit = Math.max(maxProfit, price - minPrice);   //2ms
               maxProfit = maxProfit > (diff) ? maxProfit : (diff) ;    //1ms
            }
        }
    
        return maxProfit;
    }

    public static void main(String[] args) {
        //int [] prices = {7,1,5,3,6,4};
        int [] prices = {1,2,3,4,5};
        //int [] prices = {7,6,4,3,1};
        //int [] prices = {1,2};


        System.out.println(maxProfit2(prices));
    }

}
