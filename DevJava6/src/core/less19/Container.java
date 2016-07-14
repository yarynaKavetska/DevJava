package core.less19;

public class Container<E> {
	
	private E element;

	public Container(E element) {
		this.element = element;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

//	private Object object;
//
//	public Container(Object object) {
//		this.object = object;
//	}
//
//	public Object getObject() {
//		return object;
//	}
//
//	public void setObject(Object object) {
//		this.object = object;
//	}
}
