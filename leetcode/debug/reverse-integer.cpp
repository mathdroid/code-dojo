#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  int x, neg;
  long int xLong, yLong;
  cin >> x;
  neg=0;
  xLong=x;
  yLong=0;
  if (x<0) {
    neg=1;
    xLong=x*(-1);
  }
  while (xLong>0) {
    yLong=10*yLong + xLong%10;
    xLong = (long int) xLong/10;
    //cout << xLong << endl;
    //cin >> xLong;
  }
  if (yLong > 2147483647) {
    yLong =0;
  }
  if (neg==1) {
    yLong= (int) yLong*(-1);
  }
  int result = (int) yLong;
  cout << result << endl;
  //cout << (int) x/10 << endl;
  return 0;
}
