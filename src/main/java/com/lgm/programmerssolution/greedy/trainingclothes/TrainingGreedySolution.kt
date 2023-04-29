package com.lgm.programmerssolution.greedy.trainingclothes

class TrainingGreedySolution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        lost.sort()
        reserve.sort()

        // 체육복을 잃어버렸지만 여분이 있는 학생
        var lostAndReservedCount: Int = lostAndReserveStudentCount(lost, reserve)
        // 체육복이 이미 있는 학생
        var alreadyExistCount: Int = n - (lost.size - lostAndReservedCount)
        // 체육복을 빌릴 수 있는 학생
        var reservedCount: Int = reservedStudentCount(lost, reserve)

        // 체육복이 이미 있는 학생 + 체육복을 빌릴 수 있는 학생 = 체육수업을 들을 수 있는 학생
        var answer = alreadyExistCount + reservedCount
        return answer
    }

    // 체육복을 빌림 받아 체육 수업을 들을 수 있는 학생의 수
    fun reservedStudentCount(losts: IntArray, reserves: IntArray): Int {
        var count: Int = 0
        var tmpLosts: IntArray = losts
        var tmpReserves: IntArray = reserves

        // 여분의 체육복이 있으면서 1벌을 잃어버린 학생은 빌릴 필요가 없기 때문에 lost 배열에서 제외한다.
        // 또한 그런 학생들은 빌려줄 수도 없기 때문에 reserves에서도 제외한다.
        tmpLosts = tmpLosts.filter { !reserves.contains(it) }.toIntArray()
        tmpReserves = tmpReserves.filter { !losts.contains(it) }.toIntArray()

        for (reserve: Int in tmpReserves) {
            var frontNumber: Int = reserve - 1
            var backNumber: Int = reserve + 1

            // 빌려줄 수 있는 학생의 앞 번호 또는 뒷 번호에 있는 학생이 체육복이 없을 때 빌려주고,
            // 체육복을 받은 학생은 losts 배열에서 제외한다.
            if (tmpLosts.contains(frontNumber)) {
                count++
                tmpLosts = tmpLosts.filter { it != frontNumber }.toIntArray()
            } else if (tmpLosts.contains(backNumber)) {
                count++
                tmpLosts = tmpLosts.filter { it != backNumber }.toIntArray()
            }
        }
        return count
    }

    // 여분의 체육복이 있으면서 잃어버린 학생들 수
    fun lostAndReserveStudentCount(losts: IntArray, reserves: IntArray): Int {
        var tmpLosts: IntArray = losts
        tmpLosts = tmpLosts.filter { reserves.contains(it) }.toIntArray()
        return tmpLosts.size
    }

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/42862
    문제 설명
    점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

    전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

    제한사항
    전체 학생의 수는 2명 이상 30명 이하입니다.
    체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
    여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
    입출력 예
    n	lost	reserve	return
    5	[2, 4]	[1, 3, 5]	5
    5	[2, 4]	[3]	        4
    3	[3]	    [1]	        2
    입출력 예 설명
    예제 #1
    1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

    예제 #2
    3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
     */
}