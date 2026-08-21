class Solution {
    public void setZeroes(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int j=0; j<cols; j++){
            if(nums[0][j] == 0)
                firstRowZero = true;
        }
        for(int i=0; i<rows; i++){
            if(nums[i][0] == 0)
                firstColZero = true;
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(nums[i][j] == 0){
                    nums[i][0] = 0;
                    nums[0][j] = 0;
                }
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(nums[i][0] == 0 || nums[0][j] == 0)
                    nums[i][j] = 0;
            }
        }

        if(firstRowZero){
            for(int j=0; j<cols; j++)
                nums[0][j] = 0;
        }

        if(firstColZero){
            for(int i=0; i<rows; i++)
                nums[i][0] = 0;
        }
    }
}