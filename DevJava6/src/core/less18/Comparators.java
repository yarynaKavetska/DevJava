package core.less18;

import java.util.Comparator;

public interface Comparators {

	public static Comparator<String> ascStringComparator(){
		return new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
	}
	
	public static Comparator<String> descStringComparator(){
		return ascStringComparator().reversed();
	}
}
