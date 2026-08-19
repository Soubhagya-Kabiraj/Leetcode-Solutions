class Solution {
private:
    int sumDigs(int x){
        int sum = 0;
        while(x){
            sum += (x%10);
            x /= 10;
        }
        return sum;
    }
public:
    int minElement(vector<int>& nums) {
        int min = INT_MAX;
        for(int each: nums){
            int sum = sumDigs(each);
            if(sum < min) min = sum;
        }
        
        return min;
    }
};