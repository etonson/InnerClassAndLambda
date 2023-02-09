package lambdaclass;

public class ExampleLabdaCH7 {
	@FunctionalInterface
	interface IFABS {
		int abs(int a);
	}

	public static void main(String[] args) {
		ExampleLabdaCH7 ex = new ExampleLabdaCH7();
		ex.test();
	}

	public void test() {
		CABS objAbs = new CABS();
		IFABS obj2 = (int i) -> objAbs.myabs(i);
		System.out.println(obj2.abs(-7));
		IFABS obj3 = objAbs::myabs;
		System.out.println(obj3.abs(-9));
	}

	class CABS {
		public int myabs(int x) {
			return x > 0 ? x : (-1) * x;
		}
	}
}
