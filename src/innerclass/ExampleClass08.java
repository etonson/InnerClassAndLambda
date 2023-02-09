package innerclass;

public class ExampleClass08 {

	public static void main(String[] args) {
		Runnable task1 = new Runnable() {
			public void run() {
				for (int i = 1; i <= 3; i++) {
					try {
						Thread.sleep((long) (1000 * Math.random()));
					} catch (InterruptedException e) {
					}
					System.out.println(Thread.currentThread().getName() + " is running");
				}
			}
		};
		Thread obj = new Thread(task1);
		obj.start();
	}
}