package templates;

class SumClosestToZero {
    int[] arr;
    Integer[][] dp;
    int total;
    public int sumClosestToZero(int[] arr) {
        total = 0;
        for (int val : arr) {
            total += val;
        }
        dp = new Integer[arr.length][2 * total + 1];
        this.arr = arr;
        return Math.abs(dfs(0, 0));
    }

    private int dfs(int index, int sum) {
        int n = arr.length;
        if (index == n) {
            return 0;
        }
        if (dp[index][sum + total] != null) {
            return dp[index][sum + total];
        }
        int val = arr[index];

        // + val
        int a = val + dfs(index + 1, sum + val);

        // - val
        int b = -val + dfs(index + 1, sum - val);

        int target = -sum;

        if (Math.abs(a - target) < Math.abs(b - target)) {
            return dp[index][sum + total] = a;
        }
        return dp[index][sum + total] = b;
    }
}
