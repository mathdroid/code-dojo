#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  string s;
  int sVal=0;
  cin >> s;
  for (int i=0;i<((int) s.length());i++) {
    if ((s[i]=='i')||(s[i]=='I')) {
      sVal++;
    }
    else if ((s[i]=='v')||(s[i]=='V')) {
      if ((s[i-1]=='i')||(s[i-1]=='I')) {
        sVal=sVal+3;
      }
      else {
        sVal=sVal+5;
      }
    }
    else if ((s[i]=='x')||(s[i]=='X')) {
      if ((s[i-1]=='i')||(s[i-1]=='I')) {
        sVal=sVal+8;
      }
      else {
        sVal=sVal+10;
      }
    }
    else if ((s[i]=='l')||(s[i]=='L')) {
      if ((s[i-1]=='x')||(s[i-1]=='X')) {
        sVal=sVal+30;
      }
      else {
        sVal=sVal+50;
      }
    }
    else if ((s[i]=='c')||(s[i]=='C')) {
      if ((s[i-1]=='x')||(s[i-1]=='X')) {
        sVal=sVal+80;
      }
      else {
        sVal=sVal+100;
      }
    }
    else if ((s[i]=='d')||(s[i]=='D')) {
      if ((s[i-1]=='c')||(s[i-1]=='C')) {
        sVal=sVal+300;
      }
      else {
        sVal=sVal+500;
      }
    }
    else if ((s[i]=='m')||(s[i]=='M')) {
      if ((s[i-1]=='c')||(s[i-1]=='C')) {
        sVal=sVal+800;
      }
      else {
        sVal=sVal+1000;
      }
    }
  }

    cout << sVal << endl;
}
