package core.less15;

public class Main {
	
	private static final Converter<PersonDTO> CONVERTER = 
			new Converter.Builder<PersonDTO>().addSetting("name", "name")
			.addSetting("age", "age").addSetting("nick", "nickName")
			.setClass(PersonDTO.class).build();

	public static void main(String[] args) {
		//Create
		Person person = new Person(1, "Ivan", 18, "Chui");
		//Map
		PersonDTO dto = CONVERTER.convert(person);
		System.out.println(dto);
	}

}
