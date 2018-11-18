package SkipList;

public class SkipList_Node {
  String data;
  int level;
  SkipList_Node[] forward;
  int lvlsize;
  
  SkipList_Node(String s, int level) {
    this.data = s;
    this.level = level;
    lvlsize = 0;
    this.forward = new SkipList_Node[level + 1];
  }

  
  public boolean setForward(int level, SkipList_Node forward) { 
	  this.forward[level] = forward;
	  lvlsize++;
	  return true;
	  }
	  
  String getData() { return data; }

  public SkipList_Node getForward(int level){
	  return this.forward[level];
  }
  
}