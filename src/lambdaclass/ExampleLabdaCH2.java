package lambdaclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleLabdaCH2 {
	public static void main(String[] args) {
		List<String> objList = new ArrayList<String>();
		objList.add("apple");
		objList.add("abc");
		objList.add("eton");
		Collections.sort(objList, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
		System.out.println(objList);
	}
}