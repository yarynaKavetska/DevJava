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
		rec(2440, 0, 0);
	}
	
	
	/**Дано 4-х значне число.Потрібно написати рекурсивний
	 *  метод,який буде перевіряти чи є в даному числі непарні
	 *   цифри і вивести їх на екран і знайти їхню суму, якщо 
	 *   немає то перевірити наявність нулів в числі.(не 
	 *   використовуючи циклів ...*/
	
	//Тут згідно умови ось такий метод, як бачите дуже не красивий
	//тому думаю умова не зовсім правильна
	//також є взагалі не рекурсивне рашення
	//і без циклів + варіани вирішення через поля класів
	static void rec(int number, int sum, int count){
		int ost = number%10;
		if(number!=0){
			if(ost%2!=0){
				System.out.println(ost);
				rec(number/10, sum+ost, count);
			}else if(ost==0){
				rec(number/10, sum, ++count);
			}else{
				rec(number/10, sum, count);
			}
		}else{
			if(sum!=0){
				System.out.println("sum = "+sum);
			}else{
				System.out.println("count = "+count);
			}
		}
	}
	
	static int fact(int a){
		int result;
		if(a==1)return 1;
		result = fact(a-1)*a;
		return result;
	}
}
