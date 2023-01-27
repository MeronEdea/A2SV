class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList();
        int n = nums.length, m = l.length;
        for (int i = 0; i < m; i ++) {
            int left = l[i], right = r[i];
            if (right - left + 1 < 2) {
                result.add(false);
            } else {
                int[] arr = nums.clone();
                Arrays.sort(arr, left, right + 1);
                int diff = arr[left + 1] - arr[left];
                boolean valid = true;
                for (int j = left + 2; j <= right; j ++) {
                    if (arr[j] - arr[j - 1] != diff) {
                        valid = false;
                        break;
                    }
                }
                result.add(valid);
            }
        }
        return result;
        
    }
}
