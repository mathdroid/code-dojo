//MUHAMMAD MUSTADI 18 NOV 2014.
//JOSEPHUS PROBLEM++
//GIVEN THE NUMBER OF ELEMENTS AND THE INDEX TO DIE LAST,
//GIVE THE SIZE OF JUMP
#include <cmath>
#include <cstdlib>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <string>

using namespace std;

int y(int n,int m){
    int s=1,i;
    for(i=2;i<=n-1;i++)
        s=(s+m-1)%i+1;
    return s+1;

}

int main() {
  int m,n;

  while(1){
    scanf("%d",&n);
    if(n==0)break;
    for(m=1;;)
    {
        if(y(n,m)==2)break;
        m++;
    }

    printf("%d\n",m);

  }
}
