package voleyballers;

import java.io.*;
import java.util.Hashtable;
import java.util.Vector;

public class ObjectPlus implements Serializable {

	private static Hashtable extensions = new Hashtable();

	public ObjectPlus() {
		Vector extension = null;
		Class clas = this.getClass();

		if (extensions.containsKey(clas)) {
			extension = (Vector) extensions.get(clas);
		} else {
			extension = new Vector();
			extensions.put(clas, extension);
		}

		extension.add(this);
	}

	public static void Save(ObjectOutputStream stream) throws IOException {
		stream.writeObject(extensions);
	}

	public static void Load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		extensions = (Hashtable) stream.readObject();
	}

	// the class method, acting on the extensibility of the class
	public static Vector Show(Class clas) throws Exception {

		Vector extension = null;

		if (extensions.containsKey(clas)) {
			extension = (Vector) extensions.get(clas);
		} else {
			throw new Exception("No class " + clas);
		}
 
		return extension;
	}

	public static <T> Vector<T> getExtension(Class<T> clazz) {
		return (Vector<T>) extensions.get(clazz);
	}

}