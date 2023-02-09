package innerclass;

public class ExampleClass06 {
	public static void main(String[] args) {
		CB06 obj = new CB06();
		obj.runAnonymousMethod();
	}
}
class CB06 {
	public void runAnonymousMethod() {
		int var= 200;
		(new Object() {
			public void show() {
				System.out.println("由匿名類別新增show method");
				System.out.println("var=" + var);
			}
		}).show();
	}
}