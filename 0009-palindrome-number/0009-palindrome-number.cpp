class Solution {
public:
    bool isPalindrome(long long int x) {
        if(x<0) {
            return false;
        } else if (x > INT_MAX || x < INT_MIN) {
            return 0;  
        } else {
            long long int rev = 0;
            long long int r;
            for(int i=x;i>0;i/=10) {
                r=i%10;
                rev=rev*10+r;
            }

            if(x==rev) 
                return true;
            else 
                return false;
        }
        
    }
};