package innerclass;

public class ExampleClass05 {
	public static void main(String[] args) {
		CB objX = new CB();
		objX.runMethod();
	}
}
class CA{
	public int var;
	public CA() {var=20;}
	public void show1() 
	{
		System.out.println("類別A的show1執行中,var="+var);
	}
	public void show2() 
	{
		System.out.println("類別A的show2執行中,var="+var);
	}
}

class CB{
	public void runMethod() 
	{
		CA objA = new CA() 
		{
			public void show1() 
			{
				System.out.println("由匿名類別改寫show1函式");
				System.out.println("var="+var);
			}
			public void show3() 
			{
				System.out.println("由匿名類別新增show3函式");
				System.out.println("var="+var);
			}
		};
		objA.var=50;
		objA.show1();
		objA.show2();
//		objA.show3(); 無法執行
		System.out.println("---------------------");
		CA obj2 = new CA();
		obj2.var=30;
		obj2.show1();
		obj2.show2();
	}
}