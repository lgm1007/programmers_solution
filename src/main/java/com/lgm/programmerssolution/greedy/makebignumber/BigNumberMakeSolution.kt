package com.lgm.programmerssolution.greedy.makebignumber

import java.util.Stack

class BigNumberMakeSolution {
    fun solution(number: String, k: Int): String {
        var numberStack: Stack<Int> = Stack()
        var count = k
        var answer = ""

        for (i in 0 until (number.length)) {

            var c: Char = number.get(i)
            var arrayItem: Int = Character.getNumericValue(c)

            if (i < (number.length - 1)) {
                var nextc: Char = number.get(i + 1)
                var nextArrayItem: Int = Character.getNumericValue(nextc)

                numberStack.push(arrayItem)

                // 다음 배열의 숫자가 스택의 숫자보다 클 경우
                // 스택에서 맨 위의 요소를 제거한 후 count - 1
                while (!numberStack.empty() && nextArrayItem > numberStack.peek() && count > 0) {
                    numberStack.pop()
                    count--
                }
            } else {
                numberStack.push(arrayItem)
            }

        }

        // count가 0보다 큰 경우에는 스택의 선입 요소부터 차례로 자른다.
        // 0 <= x <= (스택 사이즈 - 1 - count)
        if (count > 0) {
            var slicedList = numberStack.slice(0..(numberStack.size - 1 - count))

            for(item in slicedList) {
                answer += item.toString()
            }
        } 
        // count가 0 이하라면 스택에서 꺼낸 값을 거꾸로 가져온다.
        // 스택에 먼저 넣은 값이 숫자의 앞 자리 수이기 때문
        else {
            while (!numberStack.empty()) {
                var item: Int = numberStack.pop()
                answer = item.toString() + answer
            }
        }

        return answer
    }

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/42883
    문제 설명
    어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

    예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

    문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

    제한 조건
    number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
    k는 1 이상 number의 자릿수 미만인 자연수입니다.
    입출력 예
    number	        k	    return
    "1924"	        2	    "94"
    "1231234"	    3	    "3234"
    "4177252841"	4	    "775841"
     */
}