package core.less10;

public class A {

	static {
		System.out.println("Static block");
	}
	
	{
		System.out.println("Non static block");
	}
	
	static void doStatic(){}
	
	void doNotStatic(){}
}
