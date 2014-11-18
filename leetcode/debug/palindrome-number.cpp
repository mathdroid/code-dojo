#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  int x;
  bool isPal;
  cin >> x;
  if (x<0) {
    isPal = false;
  }
  else if (x<10) {
    isPal = true;
  }
  else {
    while(x>0) {
      x=(int)x/10;
    }
  }
  cout << isPal << endl;
  return 0;
}
