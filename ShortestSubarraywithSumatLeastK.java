/*
Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1], k = 1
Output: 1
Example 2:

Input: nums = [1,2], k = 4
Output: -1
Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3
 

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
1 <= k <= 109
*/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Info> queue = new LinkedList<>();
        long currSum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; ++i){
            currSum += nums[i];
            if(currSum >= k)
                ans  = Math.min(ans, i+1);
            
            while(!queue.isEmpty() && currSum - queue.peekFirst().sum >= k){
                Info info = queue.pollFirst();
                ans = Math.min(ans, i - info.idx );
            }
            
            while(!queue.isEmpty() && queue.peekLast().sum > currSum){
                queue.pollLast();
            }
            
            queue.add(new Info(currSum, i));
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
class Info{
    long sum;
    int idx;
    
    public Info(long sum, int idx){
        this.sum = sum;
        this.idx = idx;
    }
}
