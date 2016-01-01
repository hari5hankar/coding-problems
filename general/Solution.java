import java.io.*;
import java.util.*;

/*
You're given a vector of vectors of words, e.g.: 
[['quick', 'lazy'], ['brown', 'black', 'grey'], ['fox', 'dog']['jumps']]. 

Write a generalized function that prints all combinations of one word from the first vector, one word from the second vector, etc. 
The solution may not use recursion. 
NOTE: the number of vectors and number of elements within each vector may vary.

For the input above, it should print (in any order): 
quick brown fox 
quick brown dog 
quick black fox 
quick black dog 
... 
lazy grey dog
*/

class Solution {
  
  /*
  Main method, for testing.
  */
  public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    list1.add("quick");
    list1.add("lazy");

    List<String> list2 = new ArrayList<>();
    list2.add("brown");
    list2.add("black");
    list2.add("grey");

    List<String> list3 = new ArrayList<>();
    list3.add("fox");
    list3.add("dog");

    List<List<String>> listOfLists = new ArrayList<>();
    listOfLists.add(list1);
    listOfLists.add(list2);
    listOfLists.add(list3);

    printCombinations(listOfLists);
  }

  /*
  This is the public function which accepts a List<List<String>>, and calls a recursive helper function to do the work.
  */
  public static void printCombinations(List<List<String>> listOfLists) {
    printCombinations(listOfLists, new ArrayList<String>(), 0);
  }

  /*
   @param      listofLists, the original List<List<String>>
   @param      printList, a List<String> which is populated with a line to be printed.
   @param      index, the index used to identify a list within the recursion.
   
   Every call of this function has a List<String> ('listOfStrings') associated with it, obtained by using 'index'. 
   The first call to this function will specify index as 0, the subsequent calls increment index by 1 and recurse. 
   Thus, {index == the number of lists in the original listOfLists}, becomes the base case for the recursion.
   
   In every call of this function, we add the first element of 'listOfStrings' to printList and recurse. 
   When the recursion returns, the function adds the second element to printList and recurses again. And so on...
   When the base case occurs, the function prints out the elements of printList. 
    
  */
  private static void printCombinations(List<List<String>> listOfLists, List<String> printList, int index) {

    if (index == listOfLists.size()) {
      for (String s : printList)
        System.out.print(s + " ");
      System.out.println();
      return;
    }

    List<String> listOfStrings = listOfLists.get(index);

    for (String s : listOfStrings) {
      int printListIndex = printList.size();
      printList.add(printListIndex, s);
      printCombinations(listOfLists, printList, index + 1);
      printList.remove(printListIndex);
    }
  }

}
