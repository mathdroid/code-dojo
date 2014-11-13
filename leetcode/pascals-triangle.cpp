#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  int numRows;
  //int temp=1;
  vector<int> inside, lastInside;
  cin >> numRows;
  for (int i=0;i<=numRows;i++) {

    inside.resize(i+1);
    //PRINT INSIDE VECTORS HERE
    for (int j=0;j<i;j++) {
      if ((j==0)||(j==i-1)) {
        cout << 1 << " ";
        inside[j] = 1;
      }
      else {
        inside[j]=lastInside[j]+lastInside[j-1];
        cout << inside[j] << " ";
      }
    }
    cout << endl;
    //INSIDE VECTOR END
    lastInside=inside;
  }
  return 0;
}
