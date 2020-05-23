import java.lang.reflect.Method;

class Util {

	// liefert die kleinste Zahl des uebergebenen Arrays
	public static int minimum(int[] values) throws ArrayNull {
		int min =0;
		if(values == null){
			throw new ArrayNull();
		}else {
			 min = values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i] < min) {
					min = values[i];
				}
			}
		}
		return min;
	}
	// konvertiert den uebergebenen String in einen int-Wert
	public static int toInt(String str) throws emptyString {
		int result = 0, factor = 1;
		if(str.equals(" ")){
			throw new emptyString();
		}else {
			char ch = str.charAt(0);
			switch (ch) {
				case '-':
					factor = -1;
					break;
				case '+':
					factor = 1;
					break;
				default:
					result = ch - '0';
			}
			for (int i = 1; i < str.length(); i++) {
				ch = str.charAt(i);
				int ziffer = ch - '0';
				result = result * 10 + ziffer;
			}
		}
		return factor * result;
	}

	// liefert die Potenz von zahl mit exp,
	// also zahl "hoch" exp (number to the power of exp)
	public static long power(long number, int exp) {
		if (exp == 0) {
			return 1L;
		}
		return number * Util.power(number, exp - 1);
	}
}

public class UtilTest {
	// Testprogramm
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
		String eingabe="";
		try{
			Class IO = Class.forName("IO");
			ClassLoader classLoader = IO.getClassLoader();
			Class IO2 = Class.forName("IO", true, classLoader);

			for(Method readString: IO.getDeclaredMethods()){
				if(readString.getName().equals("readString")){
					//eingabe = IO.readString("Zahl: ");
				}
			}
		}catch(ClassNotThere e){
			e.printStackTrace();
			System.out.print(e);
		}
		int zahl = Util.toInt(eingabe);
		System.out.println(zahl + " hoch " + zahl + " = " + Util.power(zahl, zahl));
		System.out.println(Util.minimum(new int[] { 1, 6, 4, 7, -3, 2 }));
		System.out.println(Util.minimum(new int[0]));
		System.out.println(Util.minimum(null));
	}
}

class ArrayNull extends RuntimeException {
	public ArrayNull() {
		super("Das Array ist leer");
	}

	public ArrayNull(String fehlermeldung) {
		super(fehlermeldung);
	}
}
class emptyString extends RuntimeException {
	public emptyString() {
		super("Der String ist leer");
	}

	public emptyString(String fehlermeldung) {
		super(fehlermeldung);
	}
}
class ClassNotThere extends ClassNotFoundException {
	public ClassNotThere() {
		super("Klasse existiert nicht.");
	}

	public ClassNotThere(String fehlermeldung) {
		super(fehlermeldung);
	}
}
