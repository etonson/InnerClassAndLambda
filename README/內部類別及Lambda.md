# 內部類別及Lambda
**內部類別**
**Lambda**
**函數式介面四大類型**
<br>
參考資料：
掌握Java SE11程式設計，作者；陳錦輝
[Java8 四大函数式接口](https://www.kancloud.cn/hemiao3000/java-note/1939083)

---
內部類別分成三種型式：
1. 成員內部類別(member inner class)
2. 區域內部類別(local inner class)
3. 匿名類別(anonymous class)

##  成員內部類別(member inner class)
程式語法
```java
[封裝等級][修飾字] class 外部類別名稱
{
    [封裝等級][修飾字] 外部類別成員;
    [封裝等級][修飾字] class 內部類別名稱
    {
        [封裝等級][修飾字] 內部類別成員;
    }
}
```
**注意**
1. 內部成員可宣告之修飾字，但僅限於<font color=blue>final、abstract</font>。
2. 完整類別名稱為「<font color=blue>Package 名稱.外部類別名稱.內部類別名稱</font>」。
3. 內部類別名稱可以取用外部類別成員，但勿使用<font color=red>this</font>來讀取外部類別成員，外部類別與內部類別在產生物件實體時，各自有屬於自己的this。
4. 若內部類別非宣告為<font color=blue>static</font>類別時，則不可以宣告或定義<font color=blue>static</font>類別成員。

一般類別宣告內部類別之物件變數語法：
`outerClass.innerClass objName;`
`outerClass.innerClass obj = (new outerClass(param)).new inner Class(param) ;`

<div STYLE="page-break-after: always;"></div>

**範例**
```java
public class ExampleClass01 {

	public static void main(String[] args) {
		CMyOuterClass.CMyInnerClass innerX = (new CMyOuterClass(10)).new CMyInnerClass(20);
		innerX.showInnerClass("由第7行呼叫");
		CMyOuterClass outerObj = new CMyOuterClass(100);
		CMyOuterClass.CMyInnerClass innerY = outerObj.new CMyInnerClass(200);
		innerY.showInnerClass("由第10行呼叫");
	}
}

class CMyOuterClass {
	private int outVar;
	public CMyOuterClass() {}
	public CMyOuterClass(int i) {
		outVar = i;
	}

	class CMyInnerClass {
		private int innerVar;

		public CMyInnerClass() {}

		public CMyInnerClass(int i) {
			innerVar = i;
		}
		public void showInnerClass(String str) {
			System.out.println(str+"內部類別呼叫outVar:" + outVar);
			System.out.println(str+"內部類別呼叫innerVar:" + innerVar);
		}
	}
}
```

<div STYLE="page-break-after: always;"></div>

### 透過外部類別修改內部類別實體物件參數範例

```java
public class ExampleClass02 {

	public static void main(String[] args) {
		CMyOuterClass02 innerX = new CMyOuterClass02();
		innerX.outShow("由第7行呼叫");
		innerX.changeInnerVar("由第8行呼叫");
	}
}

class CMyOuterClass02 {

	class CMyInnerClass {
		private int innerVar;

		public CMyInnerClass() {
			innerVar = 20;
		}
		public void showInnerClass() {
			System.out.println("內部類別呼叫innerVar:" + innerVar);
		}
	}
	public int outVar;
	public CMyOuterClass02() {
		outVar = 10;
	}
	public void outShow(String str) {
		System.out.println(str + "外部類別函式呼叫outVar" + outVar);
//		innerVar=100 無內部類別的物件實體
	}
	public CMyInnerClass objInner;
	public void changeInnerVar(String str) {
		objInner = new CMyInnerClass();
		System.out.println(str);
		System.out.println("run外部類別函式，修改內部類別物件實體資料");
		objInner.innerVar = 500;
		objInner.showInnerClass();
	}
}
```

<div STYLE="page-break-after: always;"></div>

**static外部類別成員存取內部類別的解決方案**
method若被宣告為static，則無法存取非static的成員，若要存取方法有二。
1. 內部類別宣告為static。
2. 外部類別的建構子建立內部類別之物件。
```java
public class ExampleClass03 {
	public static void main(String[] args) {
		ExampleClass03 obj = new ExampleClass03();
		obj.objInner.innerVar = 50;
		obj.objInner.showInnerVar();
	}

	public ExampleClass03() {
		objInner = new CMyInnerClass();
	}

	public CMyInnerClass objInner;

	class CMyInnerClass {
		public int innerVar;

		public CMyInnerClass() {
			innerVar = 20;
		}

		public void showInnerVar() {
			System.out.println("內部類別函式執行innerVar  " + innerVar);
		}
	}
}
```

<div STYLE="page-break-after: always;"></div>

## 區域內部類別(local inner class)

<font color=red>區域內部類別</font>定義於某一方法(method)內，視作某一方法內部類別，故該生命週期只限於某一方法內。
```java
public class ExampleClass04 {

	public static void main(String[] args) {
		CMyOuterClass04 outerObj = new CMyOuterClass04();
		outerObj.runOuterClassMethod();
	}
}
class CMyOuterClass04
{
	public void runOuterClassMethod() 
	{
		class CMyInnerClass{
			public int innerVar;
			public CMyInnerClass() {innerVar=20;}
			public void innerClassMethod(){
				System.out.println("區域內部類別函式執行innerVar-->"+innerVar);
			}
		}
		CMyInnerClass innerObj = new CMyInnerClass();
		System.out.println("外部類別函式執行innerVar為"+innerObj.innerVar);
		innerObj.innerVar=50;
		innerObj.innerClassMethod();
	}
}
```

<div STYLE="page-break-after: always;"></div>

## 匿名內部類別(anonymous inner class)
<font color=red>匿名內部類別</font>，屬於一種區域內部類別，但沒有名字，必須定義於某個方法內。
故，可以視為一個繼承或實作。
語法如下：
```java
Method 名稱 (param)
{
    類別名稱 物件名稱 = new [類別名稱(param)]
    {
        '匿名類別實作區'
    };
}
```
```java
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
```

<div STYLE="page-break-after: always;"></div>

**基本範例**

```java
public class CMyOuterClass05 {
	public static void main(String[] args) {
		CB objX = new CB();
		objX.runMethod();
	}
}
class CA{
	public int var;
	public CA() {var=20;}
	public void show1() 
	{
		System.out.println("類別A的show1執行中,var="+var);
	}
	public void show2() 
	{
		System.out.println("類別A的show2執行中,var="+var);
	}
}

class CB{
	public void runMethod() 
	{
		CA objA = new CA() 
		{
			public void show1() 
			{
				System.out.println("由匿名類別改寫show1函式");
				System.out.println("var="+var);
			}
			public void show3() 
			{
				System.out.println("由匿名類別新增show3函式");
				System.out.println("var="+var);
			}
		};
		objA.var=50;
		objA.show1();
		objA.show2();
//		objA.show3(); 無法執行
		System.out.println("---------------------");
		CA obj2 = new CA();
		obj2.var=30;
		obj2.show1();
		obj2.show2();
	}
} 
```

<div STYLE="page-break-after: always;"></div>

### 匿名類別新增函式範例

語法如下：
```java
Method 名稱 (param)
{
    (
        new [類別名稱(param)]
        {
            '匿名類別實作區'
            '新增函式宣告'
        }
    ).新增函式名稱;
}
```

**範例**

```java
public class ExampleClass06 {
	public static void main(String[] args) {
		CB06 obj = new CB06();
		obj.runAnonymousMethod();
	}
}
class CA06 {
	public int var;

	public CA06() {
		var = 20;
	}
}
class CB06 {
	public void runAnonymousMethod() {
		(new CA06() {
			public void show() {
				System.out.println("由匿名類別新增show method");
				System.out.println("var=" + var);
			}
		}).show();
	}
}
```

<div STYLE="page-break-after: always;"></div>

亦可寫作
```java
public class ExampleClass06 {
	public static void main(String[] args) {
		CB06 obj = new CB06();
		obj.runAnonymousMethod();
	}
}
class CB06 {
	public void runAnonymousMethod() {
		int var= 200;
		(new Object() {
			public void show() {
				System.out.println("由匿名類別新增show method");
				System.out.println("var=" + var);
			}
		}).show();
	}
}
```
<div STYLE="page-break-after: always;"></div>

### 匿名類別函式介面實作
```java
public class ExampleClass07 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("linux");
		list.add("def");
		list.add("abc");
		list.add("eton");
		list.add("windows");
		Collections.sort(list, 
			new Comparamtor<String>() {
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
```

<font color=red>匿名類別使用限制</font><br>
1. 匿名類別內可讀取外部類別成員。
2. 匿名類別內部可宣告static。
3. 匿名類別沒有名稱，所以無法建立建構子，如果new後面出現引數，則引數會被傳遞至父類別建構子內。

<div STYLE="page-break-after: always;"></div>

# Lambda
透過註記<font color=blue>@FunctionalInterface</font>，只要介面只有一個方法，仍然是函數式介面。

```java
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
```

Lambda語法架構分三個部分：
1. 區隔符號：透過<font color=blue>-></font>，將參數與程式碼區塊做出區隔。
2. 參數列表：用<font color=blue>()</font>包起來(只有一格參數則不需要)。如果參數型態編譯器可得則可用<font color=blue>var</font>宣告。
3. 程式碼區塊：如果只有一個敘述，不需要用<font color=blue>{}</font>，如果只需一個return則可省略。

```java
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
```

<div STYLE="page-break-after: always;"></div>

## 函數式介面
抽象方法或介面由工程師實作，可透過lambda實作。
```java
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
```

**限制**
1. Lambda運算式的目標型態必須是確定的函數式介面。
2. Lambda運算式只能為函數式介面建立物件。

<div STYLE="page-break-after: always;"></div>

**lambda實作執行緒**

```java
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
```

**<font color=red>ps:</font>**
由於thread是多載，保險起見做(Runnable)強轉。

<div STYLE="page-break-after: always;"></div>

```java
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
```

**Lambda與匿名類別之差異**
1. Lambda運算式只能為函數式介面提供單一抽象方法之改寫，而匿名類別則可以為任何界面提供實作，不論包含幾種抽象方法。
2. Lambda運算式只能用於函數式介面實作，匿名類別可以於抽象類別甚而繼承一般類別。
3. 匿名類別可以使用介面提供之預設方法，Lambda則不行。

<div STYLE="page-break-after: always;"></div>

## Lambda運算式與方法的參考
java傳遞方法的參考分四種方式。
1. 類別的靜態方法引用
2. 物件實體方法引用
3. 類別的實體方法引用。
4. 建構子引用。

### Lambda運算式與類別靜態方法的引用

**語法**
`類別名稱::靜態方法`
將類別名稱.靜態方法代替lambda運算式的運算式塊，將參數作為該靜態方法的參數傳入。

**範例**<br>

```java
public class ExampleLabdaCH6 {
	@FunctionalInterface
	interface IFABS {
		int abs(int a);
	}

	public static void main(String[] args) {
		ExampleLabdaCH6 ex = new ExampleLabdaCH6();
		ex.test();
	}

	public void test() {
		IFABS obj1 = (int i) -> {
			return i < 0 ? i : (-1) * i;
		};
		System.out.println(obj1.abs(-5));
		IFABS obj2 = (int i) -> CABS.myabs(i);
		System.out.println(obj2.abs(-7));
		IFABS obj3 = CABS::myabs;
		System.out.println(obj3.abs(-9));
	}

	class CABS {
		public static int myabs(int x) {
			return x > 0 ? x : (-1) * x;
		}
	}
}
```

<div STYLE="page-break-after: always;"></div>

### Lambda運算式與某物件實體方法的引用
**語法**
`物件名稱::靜態方法`
將物件名稱.靜態方法代替lambda運算式的運算式塊，將參數作為該實體方法的參數傳入。

```java
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
```
**注意：**
某物件實體方法的參考,不可用靜態方法。

<div STYLE="page-break-after: always;"></div>

### Lambda運算式與類別實體方法的引用
**語法**
`類別名稱::實體方法`
把所有抽象方法應該出現的參數當中的第一個參數當作物件名稱，而第二個之後的參數才是要轉傳到實體方法的參數。
```java
public class ExampleLabdaCH9 {
	@FunctionalInterface
	interface IMATH {
		int iAdd(CMATH o, int a,int y);
	}

	public static void main(String[] args) {
		ExampleLabdaCH9 exe = new ExampleLabdaCH9();
		exe.test();
	}

	public void test() {
		IMATH obj1 = (CMATH o, int i,int j) -> o.add(i,j);
		System.out.println(obj1.iAdd(new CMATH(), 11,-7));

		IMATH obj2 = CMATH::add;
		System.out.println(obj2.iAdd(new CMATH(), 55,66));
	}

	class CMATH {
		public int add(int x,int y) {
			return x+y;
		}
	}
}
```

<div STYLE="page-break-after: always;"></div>

### Lambda運算式與建構子的引用
**語法**
`類別名稱::new`
將類別名稱.靜態方法代替lambda運算式的運算式塊，將參數作為該實體方法的參數傳入。
```java
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
```

# 函數式介面四大類型
<table style=" width: 100%;">
<tbody>
<tr style="height: 14.2px;">
<td style="width: 100%; height: 12px; text-align: center;" colspan="4">函數式介面四大類型說明</td>

</tr>
<tr style="height: 14.2px;">
<td style="width: 20%; height: 12px; text-align: center;">介面</td>
<td style="width: 10%; height: 12px; text-align: center;">參數</td>
<td style="width: 10%; height: 12px; text-align: center;">回傳值</td>
<td style="width: 60%; height: 12px; text-align: center;">說明</td>
</tr>

<tr style="height: 14.2px;">
<td style="width: 20%; height: 12px; text-align: center;">Consumer<'T><br>消費型介面</td>
<td style="width: 10%; height: 12px; text-align: center;">T</td>
<td style="width: 10%; height: 12px; text-align: center;">void</td>
<td style="width: 60%; height: 12px; text-align: left;">配合方法<br>void accept(T t)</td>
</tr>

<tr style="height: 14.2px;">
<td style="width: 20%; height: 12px; text-align: center;">Supplier<'T><br>供給型介面</td>
<td style="width: 10%; height: 12px; text-align: center;">無參數</td>
<td style="width: 10%; height: 12px; text-align: center;">T</td>
<td style="width: 60%; height: 12px; text-align: left;">配合方法<br>T get()</td>
</tr>

<tr style="height: 14.2px;">
<td style="width: 20%; height: 12px; text-align: center;">Function<'T,R><br>函數型介面</td>
<td style="width: 10%; height: 12px; text-align: center;">T</td>
<td style="width: 10%; height: 12px; text-align: center;">R</td>
    <td style="width: 60%; height: 12px; text-align: left;">配合方法<br>R apply(T t)</td>
</tr>

<tr style="height: 14.2px;">
<td style="width: 20%; height: 12px; text-align: center;">
Boolean Predicate<'T><br>斷言型介面</td>
<td style="width: 10%; height: 12px; text-align: center;">T</td>
<td style="width: 10%; height: 12px; text-align: center;">Boolean</td>
<td style="width: 60%; height: 12px; text-align: left;">配合方法<br>Boolean test(T t)</td>
</tr>

</tbody>
</table>
<p>&nbsp;</p>

**範例**
```java
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
```