package easy

import java.util.*

// 1002. Find Common Characters
// https://leetcode.com/problems/find-common-characters/description

fun main() {
    val words = arrayOf("bella", "label", "roller")
    commonChars(words)
    print(words.joinToString {
        it
    })
}

fun commonChars(words: Array<String>): List<String> {

    // find freq of each character from each element
    val freq = words.map { word ->
        word.associateWith {
            word.count { char ->
                it == char
            }
        }
    }

    // find common character
    val common = freq.map { it.keys }.reduce { acc, chars -> acc.intersect(chars) }

    val result: List<String> = common.flatMap { char ->
        val minCount = freq.mapNotNull { it[char] }.minOrNull() ?: 0
        List(minCount) { char.toString() }
    }
    return result
}

fun commonCharsBetterSolution(words: Array<String>): List<String> {

    val commonChar = mutableListOf<String>()

    val letterCount = IntArray(26)
    Arrays.fill(letterCount, Integer.MAX_VALUE)

    for (word in words) {

        val currentWordCount = IntArray(26)

        for (element in word) {
            currentWordCount[element - 'a']++
        }

        for (i in 0 until 26) {
            letterCount[i] = Math.min(letterCount[i], currentWordCount[i])
        }
    }

    for (i in 0 until 26) {
        while (letterCount[i] > 0) {
            commonChar.add(('a' + i).toString())
            letterCount[i]--
        }
    }

    return commonChar
}