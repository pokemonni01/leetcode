package easy

//88. Merge Sorted Array
// Merge จากมากมาน้อยใส่ตัวหลังมาเรื่อยๆ

fun main() {
    val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
    merge(nums1, 3, intArrayOf(1, 2, 3), 3)
    print(nums1.joinToString {
        it.toString()
    })
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1 // Index for nums1
    var j = n - 1 // Index for nums2
    var k = m + n -1 // Index for result

    while (i >= 0 && j >= 0) {
        when {
            nums1[i] > nums2[j] -> {
                nums1[k--] = nums1[i--]
            }
            else -> {
                nums1[k--] = nums2[j--]
            }
        }
    }

    // Add remaining elements from arr1, if any
    while (i >= 0) {
        nums1[k--] = nums1[i--]
    }

    // Add remaining elements from arr2, if any
    while (j >= 0) {
        nums1[k--] = nums2[j--]
    }
}