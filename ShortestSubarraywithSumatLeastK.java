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
        int len = nums.length, left = 0;
    int res = len + 1;
    int sum = 0;
    for (int i = 0; i < len; i++) {
        sum += nums[i];
        int t = left, sumT = sum;
        while(t < i){
            sumT -= nums[t++];
            if(sumT >= k){
                sum = sumT;
                left = t;
            }
        }
        while (sum >= k) {
            res = Math.min(res, i - left + 1);
            sum -= nums[left++];
        }
    }
    return res == len + 1 ? -1 : res;
    }
}
