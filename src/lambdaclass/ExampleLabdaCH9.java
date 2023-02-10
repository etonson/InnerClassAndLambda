package lambdaclass;

public class ExampleLabdaCH9 {
	@FunctionalInterface
	interface IMATH {
		int iAdd(CMATH o, int a,int y);
	}

	public static void main(String[] args) {
		ExampleLabdaCH9 exe = new ExampleLabdaCH9();
		exe.test();
	}

	public void test() {
		IMATH obj1 = (CMATH o, int i,int j) -> o.add(i,j);
		System.out.println(obj1.iAdd(new CMATH(), 11,-7));
		
		IMATH obj2 = CMATH::add;
		System.out.println(obj2.iAdd(new CMATH(), 55,66));
	}

	class CMATH {
		public int add(int x,int y) {
			return x+y;
		}
	}
}
