//MUHAMMAD MUSTADI 18 NOV 2014.
//READS input.txt AND RETURNS THE DESIRED VALUE IN output.txt
//CONSTRAINTS: INPUT IS ASSUMED ALWAYS A POSITIVE EVEN NUMBER

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

int getHalfSum(int x, int m) {
  int a,b;
  a = x % ((int) pow(10,m));
  b = (int) (x / pow(10,m));
  return a+b;
}

inline bool isInteger(const std::string & s)
{
   if(s.empty() || ((!isdigit(s[0])) && (s[0] != '-') && (s[0] != '+'))) return false ;

   char * p ;
   strtol(s.c_str(), &p, 10) ;

   return (*p == 0) ;
}

int main() {

  //READING
  ifstream infile("input.txt");
  int N,M;
  string reading;
  getline(infile, reading);
  istringstream ss(reading);

  //ERROR CHECKS
  try{
    if (!(isInteger(reading))) {
      throw 20;
    }
    ss >> N;
    if (getline(infile, reading)) {
      throw 10;
    }
  }
  catch (int e){
    if (e==10) {
      cout << "number of line exceeds 1." <<endl;
      return 0;
    }
    if (e==20) {
      cout << "Input error. Should only contain numbers" <<endl;
      return 0;
    }
  }

  //ALGORITHM
  long int j;
  M=N/2;
  vector<int> answerVector;
  //iterate in range of possible answer.
  //((int) pow(10, M)) because any square beyond [...]
  //[...] 10^(N-2) is higher than 10^N when squared. [...]
  //[...] Should be pretty obvious.
  for(int i=0; i< ((int) pow(10, M)); i++) {
    // include all square numbers.
    j = pow(i,2);
    //compare with the sum of split
    if (getHalfSum(j,M)==i) {
      answerVector.push_back((int) j);
    }
  }

  //WRITE OUTPUT
  ofstream outfile;
  outfile.open("output.txt");
  if (answerVector.size()==0) {
    //THIS SHOULD NOT BE POSSIBLE
    outfile << "No answer found" << endl;
  }
  else if (answerVector.size()==1) {
    outfile << answerVector[0] << endl;
  }
  else
    for (int i=0;i<((int) (answerVector.size()));i++) {
      if (i==(int) (answerVector.size()) -1) {
        outfile << "dan " << answerVector[i];
      }
      else{
        outfile << answerVector[i] << ", ";
      }
    }
  outfile.close();


}
