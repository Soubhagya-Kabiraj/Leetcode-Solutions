class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<size; i++){
            int needed = target - nums[i];
            if(map.containsKey(needed))
                return new int[] {map.get(needed), i};
            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
