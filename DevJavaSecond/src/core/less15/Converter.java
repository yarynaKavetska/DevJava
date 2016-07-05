package core.less15;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter<T> {

	private Class<T> dtoClass;
	
	private final Map<String, String> settings = new HashMap<>();
	
	public T convert(Object object){
		T dto = null;
		try {
			dto = dtoClass.newInstance();//PersonDTO dto = PersonDTO.class.newInstance();
			Class<?> paramClass = object.getClass();
			for(String fieldName : settings.keySet()){
				Field field = paramClass.getDeclaredField(fieldName);
				if(!field.isAnnotationPresent(Ignore.class)){
					field.setAccessible(true);
					Object value = field.get(object);
					String dtoFieldName = settings.get(fieldName);
					Field dtoField = dtoClass.getDeclaredField(dtoFieldName);
					dtoField.setAccessible(true);
					dtoField.set(dto, value);
				}
			}
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<T> convert(List<?> objects){
		List<T> list = new ArrayList<T>();
		for(Object object : objects){
			list.add(convert(object));
		}
		return list;
	}
	
	public static class Builder<T>{
		
		private final Converter<T> converter = new Converter<>();
		
		public Builder<T> setClass(Class<T> dtoClass){
			converter.dtoClass = dtoClass;
			return this;
		}
		
		public Builder<T> addSetting(String from, String to){
			converter.settings.put(from, to);
			return this;
		}
		
		public Converter<T> build(){
			return converter;
		}
	}
}
