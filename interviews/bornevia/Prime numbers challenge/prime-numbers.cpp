//MUHAMMAD MUSTADI 18 NOV 2014.
//READS input.txt AND WRITES PRIMES BELOW THE READ NUMBER TO output.txt

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <string>

using namespace std;

inline bool isInteger(const std::string & s)
{
   if(s.empty() || ((!isdigit(s[0])) && (s[0] != '-') && (s[0] != '+'))) return false ;

   char * p ;
   strtol(s.c_str(), &p, 10) ;

   return (*p == 0) ;
}

int main() {

  //READ
  int n;
  ///cin >> n;
  ifstream infile("input.txt");
  string reading;
  getline(infile, reading);
  istringstream ss(reading);

  //ERROR CHECKS
  try{
    if (!(isInteger(reading))) {
      throw 20;
    }
    ss >> n;
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

  //INIT
  vector<int> primeVector;
  if (n>=2) {
    primeVector.push_back(2);
  }
  int divisor;

  //ALG
  for (int number=3;number<=n;number=number+2){
    //cout << number << endl;
    divisor=3;
    while(1){
      if ((divisor*divisor>number)||(number % divisor ==0)) {
        break;
      }
      else{
        divisor=divisor+2;
      }
    }
    if (divisor*divisor>number) {
      primeVector.push_back(number);
    }
  }

  //WRITE
  ofstream outfile;
  outfile.open("output.txt");
  outfile << primeVector[0] << ", ";
  for (int i=1;i < ((int) (primeVector.size()));i++){
    if (i==((int) (primeVector.size()))-1) {
      outfile << "dan " << primeVector[i];
    }
    else{
      outfile << primeVector[i] << ", ";
    }
  }
  //cout << endl;
  outfile.close();
}
