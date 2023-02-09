package innerclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleClass07 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("linux");
		list.add("def");
		list.add("abc");
		list.add("eton");
		list.add("windows");
		Collections.sort(list, 
			new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				else if (o1.length() > o2.length())
					return 1;
				else
					return 0;
			}
		}
		);
		System.out.println(list);
	}
}
