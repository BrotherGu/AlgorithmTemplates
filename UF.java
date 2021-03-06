package templates;

public class UF {
    private int[] roots;
    private int[] sizes;
    private int total;
    public UF(int total) {
        roots = new int[total];
        sizes = new int[total];
        for (int i = 0; i < total; i++) {
            roots[i] = i;
            sizes[i] = 1;
        }
        this.total = total;
    }
    public void union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        if (r1 == r2) {
            return;
        }
        int s1 = sizes[r1];
        int s2 = sizes[r2];
        int s = s1 + s2;
        if (s1 < s2) {
            roots[r1] = r2;
            sizes[r2] = s;
        } else {
            roots[r2] = r1;
            sizes[r1] = s;
        }
    }

    public int find(int x) {
        int root = x;
        while (roots[root] != root) {
            root = roots[root];
        }
        while (roots[x] != root) {
            int temp = roots[x];
            roots[x] = root;
            x = temp;
        }
        return root;
    }
}
