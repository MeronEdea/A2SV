/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
***************************/



class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, len = s.length(), number = 0;
        char operator = '+';
        
        if (s == null || len == 0) {
            return 0;
        }
        
        for (int i = 0; i < len; i++) {
            char cur_char = s.charAt(i);
            
            if (Character.isDigit(cur_char)) {
                number = number * 10 + (cur_char - '0');
            }
            if (!Character.isDigit(cur_char) && !Character.isWhitespace(cur_char) || i == len - 1) {
                if (operator == '+') {
                    stack.push(number);
                }
                else if (operator == '-') {
                    stack.push(-number);
                }
                else if (operator == '*') {
                    stack.push(stack.pop() * number);
                }
                else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                operator = cur_char;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
