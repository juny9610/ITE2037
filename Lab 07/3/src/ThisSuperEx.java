
public class ThisSuperEx {
	public static void main(String[] args) {
		LowerClass lc = new LowerClass(1,2,3);
	}
}

class UpperClass{
	int x;
	int y;
	
	public UpperClass() {
		x = 10;
		y = 20;
		System.out.println("UpperClass() 생성자 호출!");
		System.out.println("x:" + x + " y:" + y);
	}
	
	public UpperClass(int x) {
		this();
		this.x = x;
		System.out.println("UpperClass(int x) 생성자 호출!");
		System.out.println("x:" + x + " y:" + y);
	}
	
	public UpperClass(int x, int y) {
		this(x);
		this.y = y;
		System.out.println("UpperClass(int x, int y) 생성자 호출!");
		System.out.println("x:" + x + " y:" + y);
	}
}

class LowerClass extends UpperClass {
	int r;
	
	public LowerClass() {
		super();
		r = 30;
		System.out.println("LowerClass() 생성자 호출!");
		System.out.println("x:" + x + " y:" + y + " r:" + r);
	}
	
	public LowerClass(int x) {
		super(x);
		r = 30;
		System.out.println("LowerClass(int x) 생성자 호출!");
		System.out.println("x:" + x + " y:" + y + " r:" + r);
	}
	
	public LowerClass(int x, int y) {
		super(x,y);
		r = 30;
		System.out.println("LowerClass(int x, int y) 생성자 호출!");
		System.out.println("x:" + x + " y:" + y + " r:" + r);
	}
	
	public LowerClass(int x, int y, int r) {
		this(x, y);
		this.r = r;
		System.out.println("LowerClass(int x, int y, int r) 생성자 호출!");
		System.out.println("x:" + x + " y:" + y + " r:" + r);
	}
	
}