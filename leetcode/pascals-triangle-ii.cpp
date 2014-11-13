#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
  int rowIndex;
  cout << "test" << endl;
  cin >> rowIndex;
  cout << 1 << endl;
  int temp=1;
  for (int i = 1; i<=rowIndex;i++){
    cout << temp*(rowIndex+1-i)/(i) <<endl;
    temp = temp*(rowIndex+1-i)/(i);
  }
  return 0;
}
