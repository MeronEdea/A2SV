/*
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

 

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= limit <= 109
*/


class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
         int len = nums.size();
    
    deque<int> maxs;
    deque<int> mins;
    
    int maxsub = 0;
    int i = 0;
    for (int j = 0; j < len; j ++) {
        while (!maxs.empty() && nums[j] > maxs.back()) maxs.pop_back();
        while (!mins.empty() && nums[j] < mins.back()) mins.pop_back();
        
        maxs.push_back(nums[j]);
        mins.push_back(nums[j]);
        
        while (maxs.front() - mins.front() > limit) {
            if (maxs.front() == nums[i])
                maxs.pop_front();
            if (mins.front() == nums[i])
                mins.pop_front();
            i ++;
        }
        maxsub = max(maxsub, j - i + 1);
    }
    return maxsub;
    }
};
