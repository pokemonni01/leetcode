package easy

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    val result = maxProfit(prices)
    print(result)
}

// Kadane's Algorithm
fun maxProfit(prices: IntArray): Int {
    var buy = prices[0]
    var profit = 0
    for (i in prices.indices) {
        if (prices[i] < buy) {
            buy = prices[i]
        } else if (prices[i] - buy > profit) {
            profit = prices[i] - buy
        }
    }
    return profit
}