class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
    int result = 0;
    for(int num : nums){
        int a = k - num;
        int b = map.getOrDefault(a, 0);
        if(b > 0){
            map.put(a, b - 1);
            result++;
        }else{
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }
    return result;
    }
}
