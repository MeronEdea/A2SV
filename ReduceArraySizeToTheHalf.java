class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<Integer> t = new ArrayList<>();
        for (int cnt : map.values()) {
            t.add(cnt);
        }
        Collections.sort(t, Collections.reverseOrder());
        int answer = 0;
        int n = 0;
        for (int cnt : t) {
            n += cnt;
            ++answer;
            if (n * 2 >= arr.length) {
                break;
            }
        }
        return answer;
    }
}
