package easy

// 169. Majority Element

fun main() {
    val nums = intArrayOf(6,5,5)
    val result = majorityElement(nums)
    print("result = $result")
}

fun majorityElement(nums: IntArray): Int {
    var count = 0
    var candidate = 0
    nums.forEach { num ->
        if (count == 0) {
            candidate = num
        }
        if (candidate == num) {
            count++
        } else {
            count--
        }
    }
    return candidate
}