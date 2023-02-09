package lambdaclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleLabdaCH1 {
	public static void main(String[] args) {
		List<String> objList = new ArrayList<String>();
		objList.add("apple");
		objList.add("abc");
		objList.add("eton");
		Collections.sort(objList,
				(String o1, String o2) -> {
					if (o1.length() < o2.length())
						return -1;
					else if (o1.length() > o2.length())
						return 1;
					else
						return 0;
				});
		System.out.println(objList);
	}
}
