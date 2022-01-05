fun longestIncreasingSequence(arr: Array<Int>): Int {
    val sequences = arrayListOf<List<Int>>()
    val currSequence = arrayListOf<Int>()
    arr.withIndex().reduce { prev, curr ->
        val previousValue = prev.value
        val currValue = curr.value
        val currIndex = curr.index
        if (currSequence.isEmpty() && previousValue <= currValue) currSequence.add(previousValue)
        if (currValue >= previousValue) {
            currSequence.add(currValue)
        }
        if ((currValue < previousValue || currIndex == arr.lastIndex) && currSequence.size >= 2) {
            sequences.add(ArrayList(currSequence))
            currSequence.clear()
        }
        curr
    }
    println(sequences.map { it.distinct() })
    return sequences.map { it.distinct() }.maxOfOrNull { it.size } ?: 0
}

fun main() {
    println(longestIncreasingSequence(arrayOf(3, 3, 2, 1)))
    println(longestIncreasingSequence(arrayOf(3, 2, 1, 50, 51)))
    println(longestIncreasingSequence(arrayOf(1, 2, 3, 99, 45, 22, 5, 4, 3, 2, 1, 0)))
    println(longestIncreasingSequence(arrayOf(1, 2, 3, 99, 312, 22)))
    println(longestIncreasingSequence(arrayOf(9, 9, 9, 9, 10, 3, 2, 50, 51, 0, 90, 91, 92, 93)))
}