#include <bits/stdc++.h>

using namespace std;

int lengthOfLIS(vector<int>& nums) {
    int n = nums.size();
    vector<int> len (n ,1);
    for (int i=1; i<n; i++){
        for (int j=i-1; j>=0; j--){
            if (nums[j] < nums[i]){
                len[i] = max(len[j] + 1, len[i]);
            }
        }
        
    }
    int ans = 1;
    for (int i=0; i<n; i++){
        if (len[i] > ans){ans = len[i];}
    }
    return ans;
}

int main(){

}