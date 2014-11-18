//MUHAMMAD MUSTADI 18 NOV 2014.
//READS customers.csv AND MERGES THE CONTACT TO customers_merged.csv

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <string>

using namespace std;

struct Person {
  string Name, Email, Facebook, Twitter;

  Person(string Name, string Email, string Facebook, string Twitter) {
    this->Name = Name;
    this->Email = Email;
    this->Facebook = Facebook;
    this->Twitter = Twitter;
  }
};

int get_commas(string S) {
  int count=0;
  for (int i = 0;i<(int) (S.length()); i++) {
    if (S[i]==',') {
      count++;
    }
  }
  return count;
}

bool is_valid(string S) {
  if (get_commas(S)==3){return true;}else{return false;}
}

bool comparePersons(Person p, Person q) {
  //COMPARES NAMES FOR SORTING PURPOSES
  return p.Name.compare(q.Name) < 0;
}

bool is_email(string const& address) {
  //CHECKS THE ORDER OF '@' AND '.'
    size_t at_index = address.find_first_of('@', 0);
    return at_index != std::string::npos
        && address.find_first_of('.', at_index) != std::string::npos;
}

int main() {

  //READING
  ifstream infile("customers.csv");
  string reading, header;
  vector<Person> personVector;
  string name, email, facebook, twitter;
  getline(infile, header);
  int i=0;
  try
  {
    while (getline(infile, reading)) {
      if (is_valid(reading)) {
        stringstream ss(reading);
        getline(ss,name,',');
        getline(ss,email,',');
        if ((email!="")&&(!is_email(email))) {
          throw 20;
        }
        getline(ss,facebook,',');
        getline(ss,twitter,',');
        personVector.push_back(Person(name,email,facebook,twitter));
      }
      else {throw 10;}
      i++;
    }
  }
  catch (int e)
  {
    if (e==10){
      cout << "An exception occured. Mismatching row number." << endl;
    }
    else if (e==20) {
    cout << "An exception occured. Wrong format of email." << endl;
  }
  }

  //SORTING
  sort(personVector.begin(), personVector.end(), comparePersons);

  //MERGING
  for (i=(int) (personVector.size()-1);i!=0;i--) {
    if (personVector[i].Name==personVector[i-1].Name) {
      if (personVector[i-1].Email==""){
        personVector[i-1].Email=personVector[i].Email;
      }
      if (personVector[i-1].Facebook==""){
        personVector[i-1].Facebook=personVector[i].Facebook;
      }
      if (personVector[i-1].Twitter==""){
        personVector[i-1].Twitter=personVector[i].Twitter;
      }
      personVector.erase (personVector.begin()+i);
    }
  }

  //WRITING
  locale loc;
  ofstream outfile;
  outfile.open ("customers_merged.csv");
  outfile << header << endl;
  for (i=0;i<(int) (personVector.size());i++) {
    outfile << personVector[i].Name << ",";
    for (string::size_type j=0;j<personVector[i].Email.length();++j){
      outfile << tolower(personVector[i].Email[j], loc);
    }
    outfile << "," << personVector[i].Facebook << "," << personVector[i].Twitter << endl;
  }
  outfile.close();

  return 0;
}
