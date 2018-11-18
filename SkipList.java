package SkipList;

public class SkipList implements SkipList_Interface {
  SkipList_Node head;
  SkipList_Node tail;
  int level;
  int size;
  static final int levelSize = 100;
  double probability = 0.5;
  
  public SkipList() {
    head = new SkipList_Node(null, levelSize);
    tail = new SkipList_Node(null, levelSize);

    for (int i = 1; i <= levelSize; i++) {
      head.setForward(i, tail);
    }

    level = 0;
    size = 0;
  }
  
  @Override
  public SkipList_Node getHead() {
    if (size == 0)
      return null;

    return head;
  }

  //used when creating a new node
  public int randomLevel() {
    int level = 1;

    while (Math.random() < probability)
      level++;

    return level;
  }

  @Override
  //
  public boolean insert(String s) {
	  if(this.contains(s)){return false;}
	  int newlvl = this.randomLevel();
	  if(newlvl>level){level = newlvl;}
	  SkipList_Node n = new SkipList_Node(s, newlvl);
	  SkipList_Node curr = head;
	  for(int i = newlvl; i>0; i--){
		while(curr.getForward(i)!=tail&&curr.getForward(i).getData().compareTo(s)<0){
			curr=curr.getForward(i);
		}
		n.setForward(i, curr.getForward(i));
		curr.setForward(i, n);
	  }
	  size++;
	  return true;
  }

@Override
	public boolean remove(String s) {
		if(!this.contains(s)){return false;}
	
		SkipList_Node n = head;
		int i = levelSize;
		while(i>0){
			while(n.getForward(i)!=tail&&n.getForward(i).getData().compareTo(s)<=0){
				if(n.getForward(i).getData().compareTo(s)==0){
					n.setForward(i, n.getForward(i).getForward(i));
				}else {n=n.getForward(i);}
			}
			i--;
		}
		size--;
		return true;
	}

	@Override
	public String findMin() {
			if(size==0){return null;}
	return head.getForward(1).getData();
	}

	@Override
	public String findMax() {
		if(size==0){return null;}
		SkipList_Node n = head;
		for(int i = 0; i< size; i++){
			n = n.getForward(i);
		}
		return n.getData();
	}

	@Override
	public boolean empty() {
		if(size==0){
			return true;
		} else return false;
	}

	@Override
	public boolean contains(String s) {
		if(this.empty()){return false;}
		SkipList_Node n = head;
		int i = levelSize;
		while(i>0){
			while(n.getForward(i)!=tail&&n.getForward(i).getData().compareTo(s)<=0){
				if(n.getForward(i).getData().compareTo(s)==0){return true;}
				n=n.getForward(i);
			}
			i--;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int level() {
		if(size==0){return -1;} else return level;
	}

}