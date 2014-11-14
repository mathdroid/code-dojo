class Solution {
public:
    int romanToInt(string s) {
      int sVal=0;
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
        return sVal;
    }
};
