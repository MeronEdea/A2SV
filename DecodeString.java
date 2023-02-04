/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
************************************************************/


class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";
      
        for (int i = 0; i < s.length(); i++)
        {
            int count = 0;
            if (Character.isDigit(s.charAt(i)))
            {
                while (Character.isDigit(s.charAt(i)))
                {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
      
                i--;
                integerstack.push(count);
            }
            else if (s.charAt(i) == ']')
            {
                temp = "";
                count = 0;
      
                if (!integerstack.isEmpty())
                {
                    count = integerstack.peek();
                    integerstack.pop();
                }
      
                while (!stringstack.isEmpty() && stringstack.peek()!='[' )
                {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
      
                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();
                for (int j = 0; j < count; j++)
                    result = result + temp;
                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));
                result = "";
            }
            else if (s.charAt(i) == '[')
            {
                if (Character.isDigit(s.charAt(i-1)))
                    stringstack.push(s.charAt(i));
                else
                {
                    stringstack.push(s.charAt(i));
                    integerstack.push(1);
                }
            }
      
            else
                stringstack.push(s.charAt(i));
        }
        while (!stringstack.isEmpty())
        {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
        return result;
    }
}
