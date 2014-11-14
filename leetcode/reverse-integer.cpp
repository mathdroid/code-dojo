class Solution {
public:
    int reverse(int x) {
      int neg;
      long long int xLong, yLong;
      neg=0;
      xLong=(long long int) x;
      yLong=0;
      if (x<0) {
        neg=1;
        xLong=(long long int) x*(-1);
      }
      while (xLong>0) {
        yLong=10*yLong + xLong%10;
        xLong = (long long int) xLong/10;
      }
      if (yLong > 2147483647) {
        yLong =0;
      }
      if (neg==1) {
        yLong= (int) yLong*(-1);
      }
      int result = (int) yLong;
      return result;
    }
};
