package lambdaclass;
@FunctionalInterface
interface IDuplicate {
	String duplicateOperateration(String str);
}
@FunctionalInterface
interface ITrans {
	String transOperateration(String str);
}

public class ExampleLabdaCH3 {
	public static void main(String[] args) {
		CPrint objA = new CPrint();
		objA.printDupbig("helloLambda", (s) -> s + " " + s, (s) -> s.toUpperCase());
	}
}

class CPrint {
	public void printDupbig(String s1, IDuplicate obj1, ITrans obj2) {
		s1 = obj1.duplicateOperateration(s1);
		s1 = obj2.transOperateration(s1);
		System.err.println(s1);
	}
}