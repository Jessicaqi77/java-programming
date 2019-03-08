// Name:jinqi
// USC NetID:jinqi
// CSCI 455 PA5
// Fall 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in header files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

//Function : Add a new node into the list
//@para: The target list, the new node including key and value pair
bool listAdd (ListType & list , const std::string &keyTarget , int val) ;
//Function: Remove a node in the list if exists
//@para: The target list and target node's key
bool listRemove (ListType & list , const std::string &keyTarget) ;
//Function: Determine whether the list have the node with the specific key
//@para: The target list and the target node's key
bool listContains(ListType & list , const std::string &keyTarget) ;
//Function: Obtain the value of the desired key in the list
//@para: The target list and the target node's key
int * listGetVal(ListType & list , const std::string &keyTarget) ;
//Function: Print all nodes in the list
//@para: The target list
void listPrint (ListType & list) ;
//Function: Get the number of nodes in the list
//@para: The target list
int listSize(ListType & list) ;


// keep the following line at the end of the file
#endif
