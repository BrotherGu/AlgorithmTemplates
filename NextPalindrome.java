package templates;

public class NextPalindrome {
    public int[] nextPalindrome(int[] arr, int base) {
        int n = arr.length;
        int left = (n - 1) / 2;
        while (left >= 0) {
            int val = arr[left];
            if (val < base - 1) {
                arr[left] = val + 1;
                arr[n - 1 - left] = val + 1;
                break;
            } else {
                arr[left] = 0;
                arr[n - 1 - left] = 0;
                left--;
            }
        }
        if (left < 0) {
            arr = new int[n + 1];
            for (int i = 1; i < n; i++) {
                arr[i] = 0;
            }
            arr[0] = 1;
            arr[n] = 1;
        }
        return arr;
    }
}
