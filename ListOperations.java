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
 **    Last modification: 3/24/2016                                                **
 **                                                                                **
 ************************************************************************************/

public class ListOperations {
  
  public static void main(String[] args){
    MyListOfInts L=null;
    
    //calculate numbers in list
    for (int i=0; i<5;i++){
      //int ran = (int) (100.0* Math.random());
      int ran = i+2;
      L=new MyListOfInts(ran, L);      
    }
    
    //print results
    System.out.println("All numbers in the list:");
    printMyList(L);
    System.out.println();
    
    System.out.println("Sum="+sumOfMyList(L));
    System.out.println("Max="+maxOfMyList(L));
    System.out.println("Length="+lengthOfMyList(L));
    
    L=reverseMyList(L);
    System.out.println("All numbers in the reversed list:");
    printMyList(L);
    System.out.println();
    
    System.out.println("Remove 3");  
    MyListOfInts LL=removeANumberFromMyList(L, 3);
    System.out.println("All numbers in the new list:");
    printMyList(LL);    
    System.out.println();    
    
    System.out.println("All numbers in the previous list:");
    printMyList(L);
    System.out.println();    

    System.out.println("Insert a number in a position of the new list:");
    LL=insertANumberIntoMyList(LL, 20, 1);
    printMyList(LL);    
    System.out.println();   
    
    System.out.println("Values obtained for the special recursive method:");
    reportOnValues(LL);

  }  
  
  //print list
  public static void printMyList(MyListOfInts M){
    if(M == null){
      return;
    }
    System.out.print(M.firstInt + " ");
    printMyList(M.restOfTheInts);
  
  }
  
  //get ints sum from list    
  public static int sumOfMyList (MyListOfInts M){
    if(M == null){
      return 0;
    }
    int sum = M.firstInt;
    if(M.restOfTheInts != null){
      sum += sumOfMyList(M.restOfTheInts);
    }
    return sum;       

  }
  
  //get max int from list 
  public static int maxOfMyList (MyListOfInts M){
    if(M == null){
      return 0;
    }
    int max = M.firstInt;
    if(M.restOfTheInts != null){
      if(max < M.restOfTheInts.firstInt){
        max = maxOfMyList(M.restOfTheInts);
      }
    }
    return max;
  }  
  
  //get length of list  
  public static int lengthOfMyList (MyListOfInts M){
    int length = 0;
    if(M == null){
      return length;
    }
    if(M.restOfTheInts != null){
      length += lengthOfMyList(M.restOfTheInts);
    }
    return 1+length;
  }    

  
  //reverse list and get head of new list
  public static MyListOfInts reverseMyList (MyListOfInts M){
    if(M == null || M.restOfTheInts == null){
      return M;
    }
    
    MyListOfInts temp = M.restOfTheInts;
    M.restOfTheInts = null;
    
    MyListOfInts reverse = reverseMyList(temp);
    temp.restOfTheInts = M;
    
    return reverse;
  }      
  
  //remove a specific number from the list  
  public static MyListOfInts removeANumberFromMyList(MyListOfInts M, int removee){
    if(M == null || (removee == M.firstInt && M.restOfTheInts == null)){
      return null;
    }
    //create new head
    MyListOfInts temp = new MyListOfInts(M.firstInt, M.restOfTheInts);
    
    if(removee == temp.firstInt) return temp.restOfTheInts;
    else temp.restOfTheInts = removeANumberFromMyList(temp.restOfTheInts, removee);
    
    return temp;
  }
  
  //insert a new number in a specific position of the list
  public static MyListOfInts insertANumberIntoMyList(MyListOfInts M, int insertee, int position){
    MyListOfInts temp = M;
    if(position == 0 || temp == null){
      temp = new MyListOfInts(insertee, temp);
      return temp;
    }
    temp.restOfTheInts = insertANumberIntoMyList(temp.restOfTheInts, insertee, position - 1 );
    return temp;
  }  

  //method to call special function
  public static void reportOnValues(MyListOfInts M){ 
    if(M == null) return;
    
    System.out.println(specialRecursiveFunction(M.firstInt));
    reportOnValues(M.restOfTheInts);
  }
  
  //Special method for odd and even number
  public static double specialRecursiveFunction(int x){
    if(x == 0) return 1.0;
    if(x % 2 == 0) return 1.0 + specialRecursiveFunction(x/2);
    else return 1.0 + specialRecursiveFunction(x-1);
  }  

}
