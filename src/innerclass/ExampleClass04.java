package innerclass;

public class ExampleClass04 {

	public static void main(String[] args) {
		CMyOuterClass04 outerObj = new CMyOuterClass04();
		outerObj.runOuterClassMethod();
	}
}
class CMyOuterClass04
{
	public void runOuterClassMethod() 
	{
		class CMyInnerClass{
			public int innerVar;
			public CMyInnerClass() {innerVar=20;}
			public void innerClassMethod(){
				System.out.println("區域內部類別函式執行innerVar-->"+innerVar);
			}
		}
		CMyInnerClass innerObj = new CMyInnerClass();
		System.out.println("外部類別函式執行innerVar為"+innerObj.innerVar);
		innerObj.innerVar=50;
		innerObj.innerClassMethod();
	}
}