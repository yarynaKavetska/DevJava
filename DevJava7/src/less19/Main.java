package less19;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import less16.Person;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> entity = Class.forName("less16.Person");
		System.out.println(entity.getSimpleName());
		Field[] fields = entity.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		Person person = new Person();
		person.setAge(18);
		person.setName("Ivan");
		System.out.println(person);
		
		Field ageField = entity.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(age);
		
		Field nameField = entity.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		System.out.println(name);
		
		Method getAge = entity.getDeclaredMethod("getAge");
		Object age1 = getAge.invoke(person);
		System.out.println(age1);
		
		Method getName = entity.getDeclaredMethod("getName");
		Object name1 = getName.invoke(person);
		System.out.println(name1);
		
		Object person1 = entity.newInstance();
		System.out.println(person1);
		
		ageField.set(person1, age);
		nameField.set(person1, name);
		System.out.println(person1);
		
		Object person2 = entity.newInstance();
		System.out.println(person2);
		
		Method setAge = entity.getDeclaredMethod("setAge", int.class);
		setAge.invoke(person2, age1);
		Method setName = entity.getDeclaredMethod("setName", String.class);
		setName.invoke(person2, name1);
		System.out.println(person2);
		
	}
}