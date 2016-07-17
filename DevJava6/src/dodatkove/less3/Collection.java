package dodatkove.less3;

public class Collection {

	private Object[] objects;

	public Collection(Object[] objects) {
		this.objects = objects;
	}
	
	public Iterator getIter1(){
		return new Iter1();
	}
	
	public Iterator getIter2(){
		return new Iter2();
	}
	
	public Iterator getIter3(){
		return new Iterator() {
			
			private int position = objects.length-1;
			private int count = 0;
			
			@Override
			public Object next() {
				Integer result = (Integer) objects[position];
				if(count==3){
					count=0;
					if(result%2!=0){
						System.out.print(result+" ");
					}
				}
				count++;
				position--;
				return null;
			}
			
			@Override
			public boolean hasNext() {
				return position>=0;
			}
		};
	}
	
	public void iter4(){
		class Iter4{
			void print(){
				System.out.println();
				for (int i = 0; i < objects.length; i+=5) {
					if(((Integer)objects[i])%2==0){
						System.out.print(((Integer)objects[i])-100);
					}
				}
			}
		}
		Iter4 i = new Iter4();
		i.print();
	}
	
	private class Iter1 implements Iterator{

		private int position = 0;
		
		@Override
		public boolean hasNext() {
			return objects.length>position;
		}

		@Override
		public Object next() {
			Object result = null;
			if(position%2!=0){
				result = objects[position];
			}
			position++;
			return result;
		}
		
	}
	
	private class Iter2 implements Iterator{

		private int position = objects.length-1;
		
		@Override
		public boolean hasNext() {
			return position>=0;
		}

		@Override
		public Object next() {
			Object result = objects[position];
			position-=2;
			return result;
		}
	}
	
	public static class Iter5{
		private Integer[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2};
		private Collection collection = new Collection(array);
		
		public void print(){
			System.out.println();
			for (int i = 0; i < collection.objects.length; i+=2) {
				if(((Integer)collection.objects[i])%2==0){
					System.out.print(((Integer)collection.objects[i])+1+" ");
				}
			}
		}
	}
}
