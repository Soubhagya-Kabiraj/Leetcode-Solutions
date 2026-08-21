class Solution {
    public int maxProduct(int[] nums) {
        long min = nums[0];
        long max = nums[0];
        long result = nums[0];

        for(int i=1; i<nums.length; i++){
            long curr = nums[i];
            if(curr < 0){
                long temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(curr, curr*min);
            max = Math.max(curr, curr*max);
            result = Math.max(max, result);
        }
        return (int) result;
    }
}