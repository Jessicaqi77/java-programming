// Name:jinqi
// USC NetID:jinqi
// CSCI 455 PA5
// Fall 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

//Function: the constructor function of table with default size
//@para: none
Table::Table() {
   hashSize = HASH_SIZE ;
   hashTable = new ListType [hashSize] ;
   for (int i = 0 ; i < hashSize ; i++){
      hashTable[i] = NULL ;
   }
}
//Function: the constructor function of table with user defined size
//@para: the target table size
Table::Table(unsigned int hSize) {
   hashSize = hSize ;
   hashTable = new ListType [hashSize] ;
   for (int i = 0 ; i < hashSize ; i++){
      hashTable[i] = NULL ;
   }
}
//Function: To determine whether the target key is in the table and return value
//@para: The look up target node's key
int * Table::lookup(const string &key) {
   ListType list = hashTable[hashCode(key)] ;
   // call the function in listFuncs to get the value
   int * result = listGetVal(list , key );
   return result ;
}
//Function: To remove a target in a list
//@para: The target node's key
bool Table::remove(const string &key) {
   ListType & list = hashTable[hashCode(key)] ;
   return listRemove(list , key ) ;
}
//Function:To add a new node in the table if it does not exist
//@para: The target node with its key and value
bool Table::insert(const string &key, int value) {
   ListType & list =  hashTable[hashCode(key)] ;
   return listAdd( list , key , value ) ;
}
//Function:The number of entry
//@para:none
int Table::numEntries() const {
   int sum = 0 ;
   for (int i = 0 ; i < hashSize ; i++){
      sum += listSize(hashTable[i]) ;
   }
   return sum ;
}
//Function:To print out all nodes in the table
//@para:none
void Table::printAll() const {
   for (int i = 0 ; i < hashSize ; i++){
      listPrint(hashTable[i]) ;
   }
}
//Function:To print out the current state in the table
//@para:The stream out
void Table::hashStats(ostream &out) const {
   int max = 0 ;    // the max length of the list
   int count = 0 ;  // to record non-empty buckets
   for (int i = 0 ; i < hashSize ; i++){
      if (hashTable[i] != NULL)
         count++ ;
      int curLen = listSize(hashTable[i]) ;   // the current length of the list
      if ( curLen > max )
         max = curLen ;                       // update the max length
   }
   out << "number of buckets: " << hashSize << endl ;
   out << "number of entries: " << numEntries() << endl ;
   out << "number of non-empty buckets: " << count << endl ;
   out << "longest chain: " << max << endl ;
}

// add definitions for your private methods here
