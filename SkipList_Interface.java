package SkipList;

/*

  insert:
     		if the string is already in the skiplist, no change to
              the skiplist state, and return false
            if the string is not already in the skiplist, then a new skiplist node
              is created, the string put in as data, the new node is linked
              into the skiplist; size is incremented by 1,
              and return a true
  remove:
    		if the element being looked for is in the skiplist, unlink the node containing
              it and return true (success); size decreases by one
            if the element being looked for is not in the skiplist, return false and
              make no change to the skiplist state
  contains:
     		return true if the string being looked for is in the skiplist;

  findMin:
	    	return minimum element

  findMax:
    		return maximum element

  size:
    		return number of elements

  empty:
	    	true if no elements

  level:
    		the level of the highest node in the skiplist
    
  getHead:
      		return node that is the starter of the entire skiplist
            
*/


public interface SkipList_Interface { 
  public boolean insert(String s);
  public boolean remove(String s);
  public String findMin();
  public String findMax();
  public boolean empty();
  public boolean contains(String s);
  public int size();
  public int level(); 
  public SkipList_Node getHead();
}