class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result = 0, m = piles.length;
        for (int i = m / 3; i < m; i += 2)
            result += piles[i];
        return result;
    }
}
