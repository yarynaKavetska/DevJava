package core.less21;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> entity = Class.forName("core.less21.Person");
		System.out.println(entity.getSimpleName());
		Field[] fields = entity.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		
	}
}
