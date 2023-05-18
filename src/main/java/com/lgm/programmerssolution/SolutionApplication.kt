package com.lgm.programmerssolution

import com.lgm.programmerssolution.lottowin.LottoSolution
import com.lgm.programmerssolution.traversal.TargetNumberSolution

fun main() {
    println(targetNumberTest())
}

fun targetNumberTest(): Int {
    val targetNumberSolution = TargetNumberSolution()

    var numbers: IntArray = intArrayOf(4, 1, 2, 1)
    var target: Int = 4

    return targetNumberSolution.solution(numbers, target)
}