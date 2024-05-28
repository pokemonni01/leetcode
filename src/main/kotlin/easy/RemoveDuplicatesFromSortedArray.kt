package easy

fun main() {
    removeDuplicates(intArrayOf(1,1,2))
}

fun removeDuplicates(nums: IntArray): Int {
    var j = 1
    for (i in 1 until nums.size) {
        if(nums[i] != nums[i - 1]){
            nums[j] = nums[i]
            j++
        }
    }
    return j
}