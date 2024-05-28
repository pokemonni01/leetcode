package easy

fun main() {
    removeElement(intArrayOf(3,2,2,3), 3)
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var j = 0
    for (i in nums.indices) {
        if(nums[i] != `val`){
            nums[j] = nums[i]
            j++
        }
    }
    return j
}