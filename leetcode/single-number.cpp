class Solution {
public:
    int singleNumber(int A[], int n) {
        int ans = 0, i = 0;
        ans=A[i];
        i++;
        while (i<n){
            ans=(ans^(A[i]));
            i++;
        }
        return ans;
    }
};
