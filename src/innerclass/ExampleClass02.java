package innerclass;

public class ExampleClass02 {

	public static void main(String[] args) {
		CMyOuterClass02 innerX = new CMyOuterClass02();
		innerX.outShow("由第7行呼叫");
		innerX.changeInnerVar("由第8行呼叫");
	}
}

class CMyOuterClass02 {

	class CMyInnerClass {
		private int innerVar;

		public CMyInnerClass() {
			innerVar = 20;
		}
		public void showInnerClass() {
			System.out.println("內部類別呼叫innerVar:" + innerVar);
		}
	}
	public int outVar;
	public CMyOuterClass02() {
		outVar = 10;
	}
	public void outShow(String str) {
		System.out.println(str + "外部類別函式呼叫outVar" + outVar);
//		innerVar=100 無內部類別的物件實體
	}
	public CMyInnerClass objInner;
	public void changeInnerVar(String str) {
		objInner = new CMyInnerClass();
		System.out.println(str);
		System.out.println("run外部類別函式，修改內部類別物件實體資料");
		objInner.innerVar = 500;
		objInner.showInnerClass();
	}
}
