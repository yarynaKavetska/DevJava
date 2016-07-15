package core.less20;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	
	
	
	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> entity = Class.forName("core.less20.Person");
		System.out.println(entity.getSimpleName());
		Field[] fields = entity.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		Person person = new Person("Ivan", 18);
		Field nameField = entity.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		System.out.println(name);
		Field ageField = entity.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(age);
		
		Object person2 = entity.newInstance();
		System.out.println(person2);
		nameField.set(person2, name);
		ageField.set(person2, age);
		System.out.println(person2);
		
		Object person3 = entity.newInstance();
		Method getName = entity.getDeclaredMethod("getName");
		Object name2 = getName.invoke(person);
		System.out.println(name2);
		Method setName = entity.getDeclaredMethod("setName", String.class);
		setName.invoke(person3, name2);
		System.out.println(person3);
	}
}
