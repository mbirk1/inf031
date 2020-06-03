class Person {
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
	}
	public static Person load(DataInputStream in) throws IOException {
	}
	public static void save(String filename, List<Person> list) throws IOException {
	}
	public static void save(DataOutputStream out, Person person) throws IOException {
	}
	public static List<Person> unserialize(String filename) throws IOException, ClassNotFoundException {
	}
	public static void serialize(String filename, List<Person> persons) throws IOException {
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
