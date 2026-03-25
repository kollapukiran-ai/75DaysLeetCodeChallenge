class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = prices[0];  // minimum price so far
    int maxProfit = 0;         // maximum profit

    for (int i = 1; i < prices.size(); i++) {
        if (prices[i] < minPrice) {
            minPrice = prices[i];  // update min price
        } else {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
    }
    return maxProfit; 
    }
};