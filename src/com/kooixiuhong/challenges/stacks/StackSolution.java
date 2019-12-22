package com.kooixiuhong.challenges.stacks;

import java.util.Stack;

public class StackSolution {

    public int sumOfStack(Stack<Integer> stack) {
        int sum = 0;
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            sum += stack.peek();
            temp.push(stack.pop());
        }
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
        return sum;
    }
}
