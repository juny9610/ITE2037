
class Parent{
	int m_money;
	int f_money;
	int p_money;
	
	public void setPMoney(int m_money, int f_money) {
		this.m_money = m_money;
		this.f_money = f_money;
		this.p_money = m_money + f_money;
	}
	
	public void Pmsg() {
		System.out.println("물려줄 재산 : " + p_money);
	}

}

class Child extends Parent{
	int c_money;
	
	public void setCMoney(int m_money, int f_money, int c_money) {
		this.m_money = m_money;
		this.f_money = f_money;
		this.c_money = c_money;
		this.setPMoney(m_money, f_money);
	}
	
	public void Cmsg() {
		System.out.println("총 재산 : " + (p_money+c_money));
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Child c = new Child();
		c.setCMoney(20,30,10);
		c.Pmsg();
		c.Cmsg();
	}

}

