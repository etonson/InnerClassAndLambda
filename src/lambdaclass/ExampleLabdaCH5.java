package lambdaclass;

public class ExampleLabdaCH5 {
	public static void main(String args[]) {
		Runnable task1 = () -> {
			for (int i = 1; i <= 3; i++) {
				try {
					Thread.sleep((long) (1000 * Math.random()));
				} catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName() + " is running");
			}
		};

		Thread obj1 = new Thread(task1);
		Thread obj2 = new Thread(task1);

		obj1.start();
		obj2.start();
	}
}