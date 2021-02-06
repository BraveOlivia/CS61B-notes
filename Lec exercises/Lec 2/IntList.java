public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}


	
	public static void main(String[] args) {
		IntList l = new IntList(15,null);
		l = new IntList(10,l);
		l = new IntList(5,l);
		l.addFirst(3);
		l.addFirst(-99);
		System.out.println(l.get(0));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		System.out.println(l.get(3));
		System.out.println(l.get(4));
	}

	public int iterativeGet(int i){
		int index = 0;
		IntList p = this;
		while(i!=index){
			p = this.rest;
			index ++;
		}
		return p.first;
	}

	public int get(int i){
		if(i==0){
			return first;
		}
		return rest.get(i-1);
	}

	public void addFirst(int num){
		rest = new IntList(first, rest);
		first = num;
	}


	public int size(){
		if(rest == null){
			return 1;
		}
		return 1 + this.rest.size(); 
	}

	public int iterativeSize(){
		int size = 0;
		IntList p = this;
		while(p != null){
			size ++;
			p = p.rest;
		}
		return size;

	}
	//l=[5,10,15];
}