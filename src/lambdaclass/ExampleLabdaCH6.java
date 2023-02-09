package lambdaclass;

public class ExampleLabdaCH6 {
	@FunctionalInterface
	interface IFABS {
		int abs(int a);
	}

	public static void main(String[] args) {
		ExampleLabdaCH6 ex = new ExampleLabdaCH6();
		ex.test();
	}

	public void test() {
		IFABS obj1 = (int i) -> {
			return i < 0 ? i : (-1) * i;
		};
		System.out.println(obj1.abs(-5));
		IFABS obj2 = (int i) -> CABS.myabs(i);
		System.out.println(obj2.abs(-7));
		IFABS obj3 = CABS::myabs;
		System.out.println(obj3.abs(-9));
	}

	class CABS {
		public static int myabs(int x) {
			return x > 0 ? x : (-1) * x;
		}
	}
}
