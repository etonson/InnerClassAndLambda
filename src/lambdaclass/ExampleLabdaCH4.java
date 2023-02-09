package lambdaclass;

public class ExampleLabdaCH4 {
	public static void main(String[] args) {
		Thread obj = new Thread((Runnable) () -> {
			for (int i = 1; i < 20; i++) {
				try {
					Thread.sleep((long) (1000 * Math.random()));
				} catch (Exception e) {

				}
				System.out.println(Thread.currentThread().getName() + "  is running");
			}
		});
	obj.start();
	}
}