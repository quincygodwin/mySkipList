
package SkipList;

public class SkipList_Playground {
  
  public static void main(String[]args){
 
	  
	  
  }

  public static void printSkipList(SkipList sl) {
    SkipList_Node x = sl.getHead();
    for (int i = 0; i < sl.size(); i++) {
      System.out.print(x.forward[1].getData() + " ");
      x = x.forward[1];
    }
    System.out.println();
  }
}