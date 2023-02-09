package innerclass;

public class ExampleClass03 {
	public static void main(String[] args) {
		ExampleClass03 obj = new ExampleClass03();
		obj.objInner.innerVar = 50;
		obj.objInner.showInnerVar();
	}

	public ExampleClass03() {
		objInner = new CMyInnerClass();
	}

	public CMyInnerClass objInner;

	class CMyInnerClass {
		public int innerVar;

		public CMyInnerClass() {
			innerVar = 20;
		}

		public void showInnerVar() {
			System.out.println("內部類別函式執行innerVar  " + innerVar);
		}
	}
}