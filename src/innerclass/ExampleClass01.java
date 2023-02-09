package innerclass;

public class ExampleClass01 {

	public static void main(String[] args) {
		CMyOuterClass.CMyInnerClass innerX = (new CMyOuterClass(10)).new CMyInnerClass(20);
		innerX.showInnerClass("由第8行呼叫");
		CMyOuterClass outerObj = new CMyOuterClass(100);
		CMyOuterClass.CMyInnerClass innerY = outerObj.new CMyInnerClass(200);
		innerY.showInnerClass("由第10行呼叫");
	}

}

class CMyOuterClass {
	private int outVar;

	public CMyOuterClass() {
	}

	public CMyOuterClass(int i) {
		outVar = i;
	}

	class CMyInnerClass {
		private int innerVar;

		public CMyInnerClass() {
		}

		public CMyInnerClass(int i) {
			innerVar = i;
		}

		public void showInnerClass(String str) {
			System.out.println(str+"內部類別呼叫outVar:" + outVar);
			System.out.println(str+"內部類別呼叫innerVar:" + innerVar);
		}
	}
}
