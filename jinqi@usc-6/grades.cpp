// Name:jinqi
// USC NetID:jinqi
// CSCI 455 PA5
// Fall 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;

// the private function definition
void help() ;

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }

   // print the current state in the grades table
   grades->hashStats(cout);

   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*

   // the input command
   string cmd ;
   // the input key name
   string keyName ;
   // the input value score
   int val = 0 ;
   bool status = true ;

   // continue the loop until the status becomes false
   while(status){
      cout << "cmd>" << endl;
      cin>> cmd ;
      // based on different commands use different code parts
      // insert a node
      if (cmd == "insert"){
         cin >> keyName ;
         cin >> val ;
         // if the node does not exit, insert
         if ( grades -> insert(keyName , val))
            cout << "Insert successfully."<< endl;
         else
            cout << keyName << " already exists" << endl ;
      }
      // change a node's value which exists in the table
      else if(cmd == "change"){
         cin >> keyName ;
         cin >> val ;
         // find the original value first
         int * orginal = grades -> lookup(keyName) ;
         if (orginal == NULL)
            cout<< keyName << " does not exist." << endl ;
         else
            *orginal = val ;
      }
      // determine a node whether in the table or not
      else if (cmd == "lookup"){
         cin>> keyName ;
         if (grades -> lookup(keyName) !=NULL)
            cout<< keyName << " exist and the score is "<< *grades -> lookup(keyName)  << endl ;
         else
            cout<< keyName << " does not exist." << endl ;
      }
      // delete a node if exixts
      else if (cmd == "remove") {
         cin >> keyName ;
         if (grades -> lookup(keyName) ==NULL)
            cout<< keyName << " does not exist." << endl ;
         else {
             grades->remove(keyName);
         }
      }
      // print all nodes
      else if (cmd == "print"){
         grades-> printAll() ;
      }
      // get the table size
      else if (cmd == "size"){
         cout << "The size is: "<< grades -> numEntries() << endl ;
      }
      // get the table current size
      else if(cmd == "stats"){
         grades -> hashStats(cout) ;
      }
      // get the help lines
      else if (cmd == "help" ) {
         help();
      }
      // end, quit the loop
      else if (cmd == "quit"){
          status = false ;
      }
      // the command line is wrong and print out the help lines for reference
      else{
          cout << "ERROR: invalid command"<< endl;
          help();
      }
   }
    return 0;
}

//Function: To print all the help lines int the monitor
//@para: none
void help(){
    cout << "insert name score : Insert this name and score in the grade table. Commad is insert. " << endl ;
    cout << "change name newscore : Change the score for name. Command is change. " << endl ;
    cout << "lookup name : Lookup the name, and print out his or her score. Command is lookup." << endl ;
    cout << "remove name : Remove this student. Command is remove." << endl ;
    cout << "print : Prints out all names and scores in the table. Command is print. " << endl ;
    cout << "size : Prints out the number of entries in the table. Command is size." << endl ;
    cout << "stats : Prints out statistics about the hash table at this point. Command is stats." << endl ;
    cout << "help : Prints out a brief command summary. Command is help." << endl ;
    cout << "quit: Exits the program. Command is quit." << endl ;

}