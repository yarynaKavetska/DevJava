package core.less14;

import java.io.Serializable;

public class Container<E extends Serializable>{

	private E element;

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}
}
