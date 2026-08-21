class Solution {
    public int countValidPrefixes(String s) {
        int ans = 0;
        int ones = 0;
        int zeroes = 0;

        for(char ch:s.toCharArray()){
            if(ch == '0') zeroes++;
            else ones++;

            if(Math.abs(ones - zeroes) <= 1) ans++;
        }
        return ans;
    }
}