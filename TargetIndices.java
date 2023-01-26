class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count_less = 0;
        int count_target = 0;
 
        // Loop to count smaller elements and val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                count_target++;
            if (nums[i] < target)
                count_less++;
        }
 
        // List to store indices
        List<Integer> ans = new ArrayList<Integer>();
        while (count_target > 0) {
            ans.add(count_less++);
            count_target--;
        }
        return ans;
    }
}
