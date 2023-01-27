class Solution {
    public int minPairSum(int[] nums) {
         Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int Sum = 0;
        while(left<right) {
          Sum = Sum>(nums[left++]+nums[right--])?Sum:(nums[left-1]+nums   [right+1]);
        }
        return Sum;
    }
}
