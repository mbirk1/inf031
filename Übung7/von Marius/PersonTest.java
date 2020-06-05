import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
	private String firstname;
	private String lastname;
	private String sortname;
	public Person() { }
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		updateSortname();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
		updateSortname();
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
		updateSortname();
	}
	public String getSortname() {
		return sortname;
	}
	public void updateSortname() {
		sortname = lastname + firstname;
	}
	@Override
	public String toString() {
		return firstname + " " + lastname + " (" + sortname + ")";
	}
	public static List<Person> load(String filename) throws IOException {
		List<Person> persons = new ArrayList<>();
		DataInputStream f = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
		try{
			while(f != null){
				try{
					persons.add(load(f));
				}catch (EOFException e){
					break;
				}
			}
		} catch( FileNotFoundException e){
			System.out.print("File not found!");
		}catch (IOException e){
			System.out.print("End of File");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			f.close();
		}
		return persons;
	}
	public static Person load(DataInputStream in) throws IOException, ClassNotFoundException {
		Person person = null;
		ObjectInputStream o = new ObjectInputStream(in);
		if(in != null){
			person=(Person) o.readObject();
		}
		return person;
	}
	public static void save(String filename, List<Person> list) throws IOException {
		DataOutputStream f = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
		try{
			for(int i = 0; i<list.size();i++){
				save(f, list.get(i));
			}
		}catch(IOException e){
			System.out.print(e);
		}finally {
			f.close();
		}
	}
	public static void save(DataOutputStream out, Person person) throws IOException {
		ObjectOutputStream o = new ObjectOutputStream(out);
		o.writeObject(person);
	}
	public static List<Person> unserialize(String filename) throws IOException, ClassNotFoundException {
		List<Person> persons = new ArrayList<>();
		DataInputStream f = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
		ObjectInputStream o = new ObjectInputStream(f);
		try{
			while(f != null){
				try{
					persons.add((Person)o.readObject());
				}catch (EOFException e){
					break;
				}
			}
		} catch( FileNotFoundException e){
			System.out.print("File not found!");
		}catch (IOException e){
			System.out.print(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			f.close();
		}
		return persons;
	}
	public static void serialize(String filename, List<Person> persons) throws IOException {
		DataOutputStream f = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
		ObjectOutputStream o = new ObjectOutputStream(f);
		try{
			for(int i = 0; i<persons.size();i++){
				o.writeObject(persons.get(i));
			}
		}catch(IOException e){
			System.out.print("Error initialize Output123");
		}finally {
			f.close();
			o.close();
		}
	}
}
public class PersonTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Willy", "Wonka"));
		persons.add(new Person("Charlie", "Bucket"));
		persons.add(new Person("Grandpa", "Joe"));
		System.out.println(persons);
		
		Person.save("persons.sav", persons);
		persons = Person.load("persons.sav");
		System.out.println(persons);
		Person.serialize("persons.ser", persons);
		persons = Person.unserialize("persons.ser");
		System.out.println(persons);
	}

}
