package medium

// 80. Remove Duplicates from Sorted Array II

fun main() {
    val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    removeDuplicates(nums)
    print(nums.joinToString {
        it.toString()
    })
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) return nums.size
    val maxAppear = 2
    val map = hashMapOf<Int, Int>()
    var k = 0
    for (i in nums.indices) {
        map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        val appear = map.getOrDefault(nums[i], 0)
        if (nums[i] != nums[k]) {
            nums[k] = nums[i]
        }
        if (appear <= maxAppear) {
            k++
        }
    }
    return k
}