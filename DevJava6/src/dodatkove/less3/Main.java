package dodatkove.less3;

public class Main {

	public static void main(String[] args) {
		Integer[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2};
		Collection collection = new Collection(array);
		Iterator i1 = collection.getIter1();
		while(i1.hasNext()){
			System.out.print(i1.next()+" ");
		}
		System.out.println();
		Iterator i2 = collection.getIter2();
		while(i2.hasNext()){
			System.out.print(i2.next()+" ");
		}
		System.out.println();
		Iterator i3 = collection.getIter3();
		while(i3.hasNext()){
			i3.next();
		}
		collection.iter4();
		Collection.Iter5 iter5 = new Collection.Iter5();
		iter5.print();
		System.out.println();
		print(2345);
//		System.out.println(fact(6));
	}
	
	static void print(int number){
		System.out.println(rec(number));
	}
	
	/**Дано 4-х значне число.Потрібно написати рекурсивний
	 *  метод,який буде перевіряти чи є в даному числі непарні
	 *   цифри і вивести їх на екран і знайти їхню суму, якщо 
	 *   немає то перевірити наявність нулів в числі.(не 
	 *   використовуючи циклів ...*/
	
	
	static int rec(int number){
		int ost = number%10;
		int recNumb = 0;
		if(number!=0) recNumb=rec(number/10);
		if(recNumb%2==0){
			return 0;
		}else{
			ost+=recNumb;
			System.out.println(ost);
			return ost;
		}
	}
	
	static int fact(int a){
		int result;
		if(a==1)return 1;
		result = fact(a-1)*a;
		return result;
	}
}
