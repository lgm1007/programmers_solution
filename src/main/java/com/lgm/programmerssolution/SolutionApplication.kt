package com.lgm.programmerssolution

import com.lgm.programmerssolution.lottowin.LottoSolution

fun main() {
    val lottoSolution = LottoSolution()
    var lottos: IntArray = intArrayOf(44, 1, 0, 0, 31, 25)
    var win_nums: IntArray = intArrayOf(31, 10, 45, 1, 6, 19)

    println(lottoSolution.solution(lottos, win_nums))
}