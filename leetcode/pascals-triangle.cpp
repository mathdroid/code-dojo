class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        vector<vector<int>> outside;
        if (numRows<=0) {
            return outside;
        }
        else{

            outside.resize(numRows);
            vector<int> inside, lastInside;
            for (int i = 0; i < numRows; i++) {
                inside.resize(i+1);
                for (int j=0; j < i+1; j++) {
                    if ((j==0)||(j==i)) {
                        inside[j]=1;
                    }
                    else {
                        inside[j] = lastInside[j] + lastInside[j-1];
                    }
                }
                outside[i]=inside;
                lastInside=inside;

            }
            return outside;
        }
    }
};
