package lambdaclass;

public class ExampleLabdaCH8 {
	@FunctionalInterface
	interface IFABS {
		CABS abs(int a);
	}

	public static void main(String[] args) {
		ExampleLabdaCH8 ex = new ExampleLabdaCH8();
		ex.test();
	}

	public void test() {
		IFABS obj1 = (int i) -> new CABS(i);
		CABS o1 = obj1.abs(-4);
		System.out.println(o1.positiveValue);

		IFABS obj2 = CABS::new;
		CABS o2 = obj2.abs(-3);
		System.out.println(o2.positiveValue);
	}

	class CABS {
		public int positiveValue;

		public CABS(int x) {
			positiveValue = x > 0 ? x : (-1) * x;
		}
	}
}