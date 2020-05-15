import java.util.ArrayList;

public class Rooms {
    public static void main(String[] args){
        Furniture chair = new Chair();
        Desk desk = new Desk();
        Chair chair1 = new Chair();

        Office office = new Office(desk, chair1, chair);
    }
}
interface Furniture{

}
class Table implements Furniture{
    private static int legs = 4;
    public int getLegs(){
        return legs;
    }
}
class Desk extends Table{

}
class Chair implements Furniture{
    private static int legs = 4;
    public int getLegs(){
        return legs;
    }
}
class Office{
    private int i=0;
    ArrayList<Chair> chairs = new ArrayList<Chair>();
    ArrayList<Desk> desks = new ArrayList<Desk>();
    ArrayList<Furniture> furniture = new ArrayList<Furniture>();

    public Office( Desk desk, Chair chair, Furniture fur) {
        desks.add(desk);
        chairs.add(chair);
        furniture.add(fur);
    }
}

class Room extends Office{
    public Room(Desk desk, Chair chair, Furniture fur) {
        super(desk, chair, fur);
    }
}


