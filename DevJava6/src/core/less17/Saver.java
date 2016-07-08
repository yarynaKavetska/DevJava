package core.less17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Saver {
	
	private final File file;

	public Saver(String fileName) {
		file = new File(fileName);
	}

	public void save(PersonManagement pm){
		try(OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(pm);
			oos.flush();
		}catch (IOException e) {
		}
	}
	
	public PersonManagement restore(){
		if(file.exists()){
			try(InputStream is = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(is)){
				Object obj = ois.readObject();
				if(obj instanceof PersonManagement){
					PersonManagement pm = (PersonManagement) obj;
					return pm;
				}
			}catch (IOException | ClassNotFoundException e) {
			}
		}
		return new PersonManagement();
	}
}
