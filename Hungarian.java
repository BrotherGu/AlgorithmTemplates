package templates;
public class Hungarian {
    int total = 1000000;
    int[][] next;
    int[] match = new int[total];

    int minimumOperations(int[][] grid) {
        for (int i = 0; i < total; i++) {
            match[i] = -1;
        }
        boolean[] visited = new boolean[total];

        int count = 0;
        for (int i = 0; i < total; i++) {
            if (match[i] != -1) {
                continue;
            }
            visited = new boolean[total];
            if (dfs(i, visited)) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(int i, boolean[] visited) {
        for (int j : next[i]) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            if (match[j] == -1 || dfs(match[j], visited)) {
                match[i] = j;
                match[j] = i;
                return true;
            }
        }
        return false;
    }
}
