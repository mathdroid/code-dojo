class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result;
        result.resize(rowIndex+1);
        double temp=1;
        result[0]=1;
        int tempInt;
        if (rowIndex>0){
            for (int i = 1; i<=rowIndex;i++){
                //cout << temp*(rowIndex+1-i)/(i) <<endl;
                temp = temp*(rowIndex+1-i)/(i);
                tempInt = (int) (temp +0.5);
                result[i]=tempInt;
            }
        }
        return result;
    }
};
