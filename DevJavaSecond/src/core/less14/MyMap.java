package core.less14;

import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {

	private Set<MyEntry<K,V>> set = new HashSet<>();
	
	public void add(K key, V value){
		set.add(new MyEntry<>(key, value));
	}

	public int size() {
		return set.size();
	}
}
