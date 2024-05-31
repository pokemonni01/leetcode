package medium

//189. Rotate Array

fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7)
    rotate(nums, 3)
    print(nums.joinToString {
        it.toString()
    })
}

fun rotate(nums: IntArray, k: Int): Unit {
    if (k == 0) return
    var a = nums.last()
    for (i in nums.indices) {
        val b = nums[i]
        nums[i] = a
        a = b
    }
    rotate(nums, k - 1)
}

private fun reverseList(i: Int, j: Int, nums: IntArray) {
    var start = i
    var end = j
    while(start < end) {
        nums[start] = nums[end].also { nums[end] = nums[start] }
        start++
        end--
    }
}
fun newRotate(nums: IntArray, k: Int): Unit {
    if(nums.size < 2) return

    val modK = k % nums.size
    if(modK == 0) return

    //Reverse First Half
    reverseList(0, nums.size-1-modK, nums)

    //Reverse Second Half
    reverseList(nums.size-modK, nums.size-1, nums)

    //Reverse Whole
    reverseList(0, nums.size-1, nums)

}