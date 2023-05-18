package com.lgm.programmerssolution.traversal

import java.util.LinkedList
import java.util.Queue

class TargetNumberSolution {
    fun solution(numbers: IntArray, target: Int): Int {
        return bfs(numbers, target);
    }

    // bfs 방식으로 풀이
    fun bfs(numbers: IntArray, target: Int): Int {
        var answer: Int = 0
        var queue: Queue<Node> = LinkedList()
        queue.add(Node(0, numbers[0]))
        queue.add(Node(0, numbers[0] * -1))

        while (!queue.isEmpty()) {
            val node: Node = queue.poll()

            // 인덱스가 numbers의 맨 끝까지 도달했을 때 sum을 타겟과 비교해보고 같으면 answer 값을 카운트한다.
            if (node.index == numbers.size - 1) {
                if (node.sum == target) {
                    answer++
                }
                continue
            }

            // next 인덱스 값
            var nextIndex: Int = node.index + 1

            // next 인덱스 값이 numbers 범위를 넘어가는 것을 방지하기 위한 처리
            if (nextIndex == numbers.size) {
                continue
            }

            queue.add(Node(nextIndex, node.sum + numbers[nextIndex]))
            queue.add(Node(nextIndex, node.sum + (numbers[nextIndex] * -1)))
        }

        return answer
    }

    // index = numbers의 인덱스를 나타내는 값
    // sum = numbers에서 position 만큼 탐색하면서 가져온 값들의 합
    class Node(index: Int, sum: Int) {
        var index: Int = 0
        var sum: Int = 0
        init {
            this.index = index
            this.sum = sum
        }
    }
}

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/43165
    n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3
    사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

    제한사항
    주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
    각 숫자는 1 이상 50 이하인 자연수입니다.
    타겟 넘버는 1 이상 1000 이하인 자연수입니다.

    입출력 예

    numbers	    target	return
    [1, 1, 1, 1, 1]	3	5
    [4, 1, 2, 1]	4	2

    입출력 예 설명
     * 입출력 예 #1

    문제 예시와 같습니다.

     * 입출력 예 #2

    +4+1-2+1 = 4
    +4-1+2-1 = 4
    총 2가지 방법이 있으므로, 2를 return 합니다.
     */