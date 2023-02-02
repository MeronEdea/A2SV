/*
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
************/


class Solution {
    public int minIncrementForUnique(int[] nums) {
        TreeMap<Integer, Integer> dict
            = new TreeMap<Integer, Integer>();
        HashSet<Integer> used = new HashSet<Integer>();
 
        for (int i : nums) {
            if (dict.containsKey(i))
                dict.put(i, dict.get(i) + 1);
            else {
                dict.put(i, 1);
                used.add(i);
            }
        }
 
        int maxUsed = 0; 
        int ans = 0;
 
        for (Map.Entry<Integer, Integer> entry :
             dict.entrySet()) {
 
            int value = entry.getKey();
            int freq = entry.getValue();
 
            if (freq <= 1) 
                continue;
 
            int duplicates = freq - 1; 
           
            int cur = Math.max(value + 1, maxUsed);
            while (duplicates > 0) {
                if (!used.contains(cur)) {
                    ans += cur - value; 
                    used.add(cur);
                    duplicates--;
                    maxUsed = cur;
                }
                cur++;
            }
        }
 
        return ans;
    }
}
