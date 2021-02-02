//William Schuhmann
//1215016803
//CSE 365 - Assignment 1 - Pt 4

#include<iostream>
using namespace std;

int main(int argc, char* argv[]){
    cout << argc - 1 << endl;
    for(int i = argc - 1; i > 0; i--){
        cout << argv[i] << " ";
    }
}