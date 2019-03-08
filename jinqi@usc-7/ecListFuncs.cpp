/*  Name:jinqi
 *  USC NetID:jinqi
 *  CS 455 Fall 2018
 *
 *  See ecListFuncs.h for specification of each function.
 *
 *  NOTE: remove the print statements below as you implement each function
 *  or you will receive no credit for that function.
 *
 */

#include <iostream>
#include <vector>

#include "ecListFuncs.h"

using namespace std;

//Function: Change the vector data structure to a list
//@para: the input vector
ListType vectorToList(const vector<int> & nums) {
   ListType list = NULL;     // initial the new list
   ListType newNode = new Node(nums[0]) ;   // initial the first value in vector as the head in list
   list = newNode ;
   ListType cur = list ;  // the pointer for the new list
   for (std::size_t i = 1 ; i < nums.size() ; i++){
      newNode = new Node(nums[i]) ;
      cur ->next = newNode ;
      cur = newNode;
   }
   return list ;
}

// function: return how many continues same number are there in the list
// @para: the input list
int countRuns(ListType list) {
   int count = 0 ;
   if (list == NULL || list -> next == NULL)   // if there are 0 or 1 item, no same
      return 0 ;
   ListType pre = list ;
   ListType cur= list->next ;
   while( cur != NULL){
      int num = pre -> data ;
      if (num == cur ->data){     // find the continues same
         count++ ;
         while(cur != NULL && cur->data == num){   // until find the different item position
            pre = cur ;
            cur = cur -> next ;
         }
      }
      pre = cur ;     // move the pointer
      cur = cur -> next ;
   }
   return count ;
}

//function：order the list in the reverse order
//@para: the input list
ListType reverse(ListType list) {

   if(list == NULL || list -> next == NULL)    // if the list is empty or only 1 item, no change
      return list ;

   ListType reverseList = NULL ;  // define the new reverse list
   while(list != NULL){
      ListType node = new Node(list -> data) ; // insert the new node in the already reversed list
      node -> next = reverseList ;

      reverseList = node ;      // move the pointer
      list = list -> next ;
   }
   return reverseList ;
}

//function: remove the item in the middle position
//@para: the list
void removeMiddle(ListType &list) {
   // if the list is empty or only one item, after removing, become empty
   if (list == NULL)
      return ;
   if (list -> next == NULL){
      list = NULL ;
      return ;
   }
   // two items , the first item should be removed, and only left one item
   if (list -> next -> next == NULL){
      list = list -> next ;
      return ;
   }
   // calculate the list size and the middle position
   ListType cur = list ;
   int size = 0 ;

   while( cur != NULL){
      size += 1 ;
      cur = cur -> next ;
   }
   int mid = 0 ;
   if (size % 2 == 0)
       mid = size/2 ;
   else
      mid = size/2 + 1 ;

   // find the middle position
   cur = list ;
   int count = 1 ;
   while( count != mid - 1 ) {
      cur = cur->next;
      count ++ ;
   }
   // delete the middle and move the pointer
   ListType middle = cur->next ;
   cur -> next = middle -> next ;
   delete middle ;
   return ;
}

// function: split the original list into two parts based on the given value
//@ para: the input list, the target spilt value, the destination list a and b
void split(ListType &list, int splitVal, ListType &a, ListType &b) {
   if (list == NULL)
      return ;
   if (list -> data ==  splitVal ) {   // the first item is the target
      a = NULL;
      if (list->next == NULL)     // only one item in the original list
         b = NULL;
      else
         b = list->next;    // more than one items in the original list
   }
   // the first item is not the target
   else {
      ListType head = list ;     // set the head for a
      a = head ;
      while(list -> next != NULL ) {
         if (list ->next -> data == splitVal){    // find the target
            b = list -> next -> next ;   // set head for b
            list -> next = NULL ;   // set the last for a
            break ;
         }
           list = list -> next ;  // move the pointer
      }
      if (list == NULL)    // not find the target
         b = NULL ;
   }
   list = NULL ;     // set the original list to empty
   return ;
}
