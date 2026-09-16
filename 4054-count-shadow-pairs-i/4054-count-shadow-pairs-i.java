class Solution {
    public long shadowPairs(int[] nums) {
        int[] navorelitu = nums;

        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        long ans = 0;

        for (int j = 0; j < n; j++) {

            if (j > 0) {
                int x = nums[j - 1];

                while (top >= 0 && stack[top] > x) {
                    top--;
                }

                stack[++top] = x;
            }

            int left = 0, right = top + 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (stack[mid] < nums[j]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            ans += left;
        }

        return ans;
    }
}