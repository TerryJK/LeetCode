// Say you have an array for which the ith element is the price of a given stock
// on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one
// and sell one share of the stock), design an algorithm to find the maximum
// profit.
//
// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5
//
// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
// than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0
//
// In this case, no transaction is done, i.e. max profit = 0.
//
//
// ==================================
// Kadane's Algorithm - Since no one has mentioned about this so far :) (In case
// if interviewer twists the input)
//
// The logic to solve this problem is same as "max subarray problem" using
// Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a
// good thing for everybody to know.

// All the straight forward solution should work, but if the interviewer twists
// the question slightly by giving the difference array of prices, Ex: for {1,
// 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

// Here, the logic is to calculate the difference (maxCur += prices[i] -
// prices[i-1]) of the original array, and find a contiguous subarray giving
// maximum profit. If the difference falls below 0, reset it to zero.

public int maxProfit(int[] prices) {
       int maxCur = 0, maxSoFar = 0;
       for(int i = 1; i < prices.length; i++) {
           maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
           maxSoFar = Math.max(maxCur, maxSoFar);
       }
       return maxSoFar;
   }
  //  *maxCur = current maximum value
  //  *maxSoFar = maximum value found so far



// ==================================
// Sharing my simple and clear C++ solution

int maxProfit(vector<int> &prices) {
    int maxPro = 0;
    int minPrice = INT_MAX;
    for(int i = 0; i < prices.size(); i++){
        minPrice = min(minPrice, prices[i]);
        maxPro = max(maxPro, prices[i] - minPrice);
    }
    return maxPro;
}

// minPrice is the minimum price from day 0 to day i. And maxPro is the maximum
// profit we can get from day 0 to day i.
//
// How to get maxPro? Just get the larger one between current maxPro and
// prices[i] - minPrice.

// ==================================
// Please explain the problem more clearly!!!
//
// "If you were only permitted to complete at most one transaction (ie, buy one and
// sell one share of the stock), design an algorithm to find the maximum profit."
//
// I misunderstood the above sentence as at most either buy or sell one share of
// stock on a single day. In that case, I buy at a local minimum price and sell it
// at a local maximum to reach a maximum total profit.
//
// Please consider changing it to something like the following:
//
// If you were only permitted to complete at most one buy and at most one sell
// during the whole period of days, design an algorithm such that your profit,
// i.e., sell price minus buy price, is maximized. Note that you can only not sell
// a stock before you buy one.
//
// For example:
//
// [1,2,3,4] ==> returns 3 (buy at 1 and sell at 4)
//
// [4,3,2,1] ==> returns 0 (don't buy)
//
// [4,10,25,2,10] ==> returns 21 (buy at 4 and sell at 25)


// ==================================
// A O(1*n) solution

// 1.for prices[0] .... prices[n], prices[n+1].....
// if (prices[n] < prices[0]) then, the max profit is in prices[0]...prices[n],
// or begin from prices[n+1], otherwise, suppose prices[n+1] > prices[0], and
// max profit is happened between prices[n+1] , and pricesn+k, then if we buy at
// day 0, and sell at day n+k, we get a bigger profit.

// Base on logic above, we can have a O(1*n) solution:


public class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0)
        {
            return 0;
        }

        int max = 0, min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < min)
            {

                min = prices[i];
            }
            else
            {
                if (prices[i] - min > profit)
                {
                    profit = prices[i] - min;
                }

            }
        }



     return profit;

    }
}


// ==================================
// My jave accepted solution with O(N) time and O(1) space
// The idea is to find so far min price.

public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0 ;
    }
    int max = 0 ;
    int sofarMin = prices[0] ;
      for (int i = 0 ; i < prices.length ; ++i) {
        if (prices[i] > sofarMin) {
          max = Math.max(max, prices[i] - sofarMin) ;
        } else{
         sofarMin = prices[i];
        }
      }
     return  max ;
  }

// ==================================
