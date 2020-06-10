import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
	
	private String number = "";
	private String title = "";
	private String shortTitle = "";
	private String semester = "";
	private List<Lecturer> lecturers = new ArrayList<>();
	private List<Date> schedule = new ArrayList<>();

	public Lecture(String number, String title, String shortTitle, String semester) {
		super();
		this.number = number;
		this.title = title;
		this.shortTitle = shortTitle;
		this.semester = semester;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public List<Date> getSchedule() {
		return schedule;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(number);
		result.append(": ");
		result.append(title);
		result.append(" (");
		result.append(shortTitle);
		result.append("), ");
		result.append(semester);
		result.append("\n\t");
		for (int i = 0; i < lecturers.size(); i++) {
			if (i > 0) {
				result.append(", ");
			}
			result.append(lecturers.get(i));
		}
		for (Date date : schedule) {
			result.append("\n\t- ");
			result.append(date);
		}
		result.append("\n");
		return result.toString();
	}
	
	public static Lecture load(String filename) throws IOException {
		Lecture result = null;
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			result = load(in);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	public static Lecture load(InputStream in) throws IOException {
		String number;
		String title;
		String shortTitle;
		String semester;
		StringBuilder builder = new StringBuilder();
		DataInputStream tmp1 = new DataInputStream(in);
		int ch;
		int point = 33;
		boolean bool=false;
		String compare="";
		int[] replace = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
		try{
			while((ch = in.read()) != -1){
				if(ch==0){
					continue;
				}else{
					for(int i = 0; i<=replace.length-1;i++){
						if(ch==replace[i]){
							ch=33;
							bool=true;
						}else{
							bool=false;
						}
					}
				}
				builder.append((char) ch);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] split = builder.toString().split("!");

		number =split[1];
		title = split[2]+" "+split[3]+" "+split[4]+" "+split[5]+" "+split[6];
		shortTitle= split[7];
		semester= split[8];

		Lecture lect = new Lecture(number, title, shortTitle, semester);

		Lecturer snape = new Lecturer(split[10],split[11]);
				lect.lecturers.add(snape);
		Lecturer umbridge = new Lecturer(split[12], split[13]);
				lect.lecturers.add(umbridge);
		Lecturer lupin= new Lecturer(split[14], split[15]);
				lect.lecturers.add(lupin);

		for(int i = 16; i<split.length;i++){
			System.out.println(split[i]);
		}

		return lect;
	}
	
	public static void saveText(String filename, Lecture data) throws IOException {
		PrintWriter out = null;
		try{
			out = new PrintWriter(new FileOutputStream(filename));
			out.print(data.getNumber()+"\n"+data.getTitle()+"\n"+data.getShortTitle()+"\n"+data.getSemester()+"\n"+data.getLecturers()+"\n"+data.getSchedule());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally {
			out.close();
		}

	}

	public static Lecture loadText(String filename) throws IOException {
		BufferedReader in = null;
		Lecture lect= null;
		try{
			in=new BufferedReader(new FileReader(filename));
			String zeile = null;
			ArrayList<String> tmp = new ArrayList<>();
			while((zeile=in.readLine())!=null){
				tmp.add(zeile);
			}
			lect = new Lecture(tmp.get(0), tmp.get(1), tmp.get(2), tmp.get(3));
			String[] tmp2 = tmp.get(4).split(",");
			tmp2[0]=tmp2[0].substring(1);
			tmp2[tmp2.length-1]=tmp2[tmp2.length-1].substring(0, tmp2[tmp2.length-1].length()-1);

			for(int i = 0; i<=tmp2.length-1; i++){
				String[] tmp3= tmp2[i].split(" ");
				if(tmp3.length>2) {
					lect.lecturers.add(new Lecturer(tmp3[tmp3.length-2], tmp3[tmp3.length-1]));
				}else{
					lect.lecturers.add(new Lecturer(tmp3[0], tmp3[1]));
				}
			}
		}finally {
			in.close();
		}
		return lect;
	}
}
