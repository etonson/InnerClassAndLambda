package innerclass;

public class ExampleClass06_1 {

	public static void main(String[] args) {
		ExeClass obj = new ExeClass();
		obj.runExe();
	}
}

class ExampleClass {
	public int indx;

	public ExampleClass(int i) {
		this.indx = i;
	}
}

class ExeClass {
	public void runExe() {
		(new ExampleClass(100) {
			public void run() {
				System.out.println("由匿名類別新增runExe method");
				System.out.println("indx=" + indx);
			}
		}).run();
	}
}
