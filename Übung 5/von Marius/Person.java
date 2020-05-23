import java.util.ArrayList;

 class Person<T> implements Older<T>{
    private String name;
    private int age;
     private Object other;


     public Person( String name,  int i) {
        this.name = name;
        this.age = i;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override public <T extends Person> boolean isOlder(T other) {
        if(this.getAge() > other.getAge()){
            return true;
        }else{
            return false;
        }
    }
}

interface Older<T > {
    public <T extends Person> boolean isOlder(T other);
}

class Group<T extends Person> {
    public Group() {

    }
    ArrayList<T> group = new ArrayList<>();

    public void add(Person member) {
                group.add((T) member);
    }
    public T getOldest(){
        int index=0;
        for(int i = 0; i<=group.size()-1; i++){
            try{
                if(group.get(i+1)!=null){
                    if(group.get(i).getAge()>group.get(i+1).getAge() ){
                        index=i;
                    }else{
                        index=+1;
                    }
                }
            }catch(Exception e){
                if(group.get(i).getAge() > group.get(index).getAge()){
                    index=index+1;
                }
            }
        }
       return group.get(index);
    }

    public String get(int i) {
        return group.get(i).getName();
    }
}