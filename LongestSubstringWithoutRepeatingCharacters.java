/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
***************************************************************************************/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
     
        for(int i = 0; i < s.length(); i++)
        {
            boolean[] visited = new boolean[256];
            for(int j = i; j < s.length(); j++)
            {
                if (visited[s.charAt(j)] == true)
                break;
                else
                {
                    result = Math.max(result, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
            visited[s.charAt(i)] = false;
        }
        return result;
    }
}
