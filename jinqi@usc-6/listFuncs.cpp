// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}


//*************************************************************************
// put the function definitions for your list functions below

//Function : Add a new node into the list
//@para: The target list, the new node including key and value pair
bool listAdd (ListType & list , const string & keyTarget , int val ) {
   // if the list already has the node, we can not add a same onw
   if (listContains(list ,keyTarget ))
      return false ;
   else{
      // insert the new node in the front of the list
      ListType cur = new Node (keyTarget , val , list) ;
      list = cur ;
      return true ;
   }
}
//Function: Remove a node in the list if exists
//@para: The target list and target node's key
bool listRemove (ListType & list , const string &keyTarget) {
    if (list == NULL)
      return false ;
    ListType pre = NULL ;
    ListType cur = list ;
   while( cur ){
       // if the first node is the target
       if (list == cur && cur -> key == keyTarget ){
           cur = cur -> next ;
           delete list ;
           list = cur ;
           return true ;
       }
       // the rest of the list
       else if(cur -> key == keyTarget){
           pre -> next = cur -> next ;
           delete cur ;
           cur = pre -> next ;
           return true ;
       }
       // current node  is  not the target, search continue
       else {
           pre = cur ;
           cur = cur->next;
       }
   }
    // cannot find the target node
    return false ;
}

//Function: Determine whether the list have the node with the specific key
//@para: The target list and the target node's key
bool listContains(ListType & list , const string &keyTarget) {
   ListType cur = list ;
   while(cur != NULL){
      // currnt is the target
      if (cur -> key == keyTarget )
         return true ;
      // not find yet and not reach the end of the list
      cur = cur-> next ;
   }
   //cannot find the target node
   return false ;
}

//Function: Obtain the value of the desired key in the list
//@para: The target list and the target node's key
int *  listGetVal(ListType & list , const string & keyTarget) {
   ListType cur = list ;
   while(cur != NULL){
      // find the target and access its value
      if (cur -> key == keyTarget )
         return  & ( cur -> value );
      cur = cur-> next ;
   }
   //cannot find the target node
   return NULL ;
}
//Function: Print all nodes in the list
//@para: The target list
void listPrint (ListType & list) {
   ListType cur = list ;
   // iterate the list
   while ( cur != NULL) {
      cout << cur->key << " " << cur->value << endl;
      // move the pointer
      cur = cur->next;
   }
}

//Function: Get the number of nodes in the list
//@para: The target list
int  listSize(ListType & list ){
   ListType cur = list ;
   int count = 0 ;
   // iterate the list
   while(cur != NULL){
      count ++ ;
      cur = cur-> next ;
   }
   return count ;
}