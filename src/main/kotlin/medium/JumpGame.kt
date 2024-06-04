package medium

// 55. Jump Game
// https://leetcode.com/problems/jump-game/description

fun main() {
    val nums = intArrayOf(2,1,4,1)
    val result = canJump(nums)
    print(result)
}


// Greedy Algorithm

fun canJump(nums: IntArray): Boolean {
    var lastPos = nums.size - 1
    for (i in nums.size - 2 downTo 0) {
        if (i + nums[i] >= lastPos) {
            lastPos = i
        }
    }
    return lastPos == 0
}