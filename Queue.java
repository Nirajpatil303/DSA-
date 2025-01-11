// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    static int cap = 5;
    static int f = -1;
    static int arr[] = new int[cap];
    static int r = -1;
	static int size= 0;
    public static int front ()
    {
        if(size == 0) 
		{
			System.out.println("its empty");
			return -1;
		}
		else return arr[f];
    }
    public static void push (int x)
    {
        if(size == cap)
		{
			System.out.println("its full");
		}
		if(size == 0)
		{
			r++;f++;
		}
		else r = (r+1)%cap;
		size ++;
		arr[r] = x;
    }
    public static void pop ()
    {
        if(size == 0) 
		{
			System.out.println("its empty");
			return ;
		}
		f = (f+1)% cap;
		size--;
		if(size == 0)
		{
			f=-1;
			r=-1;
		}
    }
	public static int size()
	{
		return size;
	}
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        push(1);
        push(2);
        push(3);
        System.out.println(front());
        pop();
        pop();
        System.out.println(front());
        
    }
}