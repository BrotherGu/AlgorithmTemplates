package templates;

public class SegmentTree {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int start;
        int end;
        long cnt;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeNode root;
    public SegmentTree(int size) {
        root = build(0, size - 1);
    }

    public void insert(int target) {
        insert(root, target);
    }

    private long insert(TreeNode root, int target) {
        int start = root.start;
        int end = root.end;
        if (start > target) {
            return 0;
        }
        if (end < target) {
            return 0;
        }
        if (start == end && start == target) {
            root.cnt++;
            return 1;
        }
        long left = insert(root.left, target);
        long right = insert(root.right, target);
        root.cnt += left + right;
        return left + right;
    }
    public long queryLarger(int target) {
        return queryLarger(root, target);
    }
    private long queryLarger(TreeNode root, int target) {
        int start = root.start;
        int end = root.end;
        if (end < target) {
            return 0;
        }
        if (start > target) {
            return root.cnt;
        }
        if (start == end) {
            return 0;
        }
        long res = queryLarger(root.left, target) + queryLarger(root.right, target);
        return res;
    }

    public long querySmaller(int target) {
        return querySmaller(root, target);
    }

    private long querySmaller(TreeNode root, int target) {
        int start = root.start;
        int end = root.end;
        if (end < target) {
            return root.cnt;
        }
        if (start > target) {
            return 0;
        }
        if (start == end) {
            return 0;
        }
        long res = querySmaller(root.left, target) + querySmaller(root.right, target);
        return res;
    }

    private TreeNode build(int start, int end) {
        if (start == end) {
            return new TreeNode(start, end);
        }
        TreeNode root = new TreeNode(start, end);
        int mid = start + (end - start) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }
}
