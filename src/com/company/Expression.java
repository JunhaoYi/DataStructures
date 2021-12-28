package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')','>', '}', ']');

    public boolean isBalanced(String input) {
        if (input == null)
            throw new NullPointerException();
        var stack = new Stack<Character>();
        for (Character c : input.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
            }
            if (isRightBracket(c)) {
                if (stack.isEmpty())
                    return false;

                var top = stack.pop();

            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    private boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }
}
