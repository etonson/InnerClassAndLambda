package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FourInterface {

	public static void main(String[] args) {
		// Consumer<T>
		MyInterface.happy(6666.66, (money) -> System.out.println("消費 " + money));
		// Supplier<T>
		List<Integer> numList = MyInterface.getNumList(10, () -> (int) (Math.random() * 100));
		System.out.println(numList);
		// Function<T, R>
		String str = MyInterface.strHandler("\t\t hihi Eton", (s) -> s.trim());
		System.out.println(str);
		// Predicate<T>
		List<Integer> l = new ArrayList<>();
		l.add(102);
		l.add(172);
		l.add(13);
		l.add(82);
		l.add(109);
		List<Integer> listii = MyInterface.filterInt(l, x -> (x > 100));
		for (Integer integer : listii) {
			System.out.print(integer + ",");
		}
	}

}
class MyInterface {
	public static void happy(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}
	
	public static List<Integer> getNumList(int num, Supplier<Integer> supplier) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer n = supplier.get();
			list.add(n);
		}
		return list;
	}
	
	public static String strHandler(String str, Function<String, String> function) {
		return function.apply(str);
	}
	
	public static List<Integer> filterInt(List<Integer> list, Predicate<Integer> pre) {
		List<Integer> l = new ArrayList<>();
		for (Integer integer : list) {
			if (pre.test(integer)) {
				l.add(integer);
			}
		}
		return l;
	}
}