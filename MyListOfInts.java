/************************************************************************************
 **                                                                                **
 **    Code by: Alejandro Davila Murra                                             **
 **                                                                                **
 **    CS 2401: Elementary Data Structures and Algorithms                          **
 **    Instructor: Mahmud Shahriar Hossain                                         **
 **    TAs: Debakar Shamanta, Anthony M. Ortiz Cepeda, Andres H Olivas Aguilar     **
 **    Lab Assignment #6                                                           **
 **    Objective: The goal of this assignment is to practice recursion.            **
 **    Due Date: Sunday, March 27                                                  **
 **    Last modification: 3/15/2016                                                **
 **                                                                                **
 ************************************************************************************/

//MyListOfInts class (Nodes)
public class MyListOfInts {
  public int firstInt;
  public MyListOfInts restOfTheInts;

  //constructors
  public MyListOfInts(int f){
    firstInt=f;
  }  
  
  public MyListOfInts(int f, MyListOfInts r){
    firstInt=f;
    restOfTheInts=r;
  }
} 
