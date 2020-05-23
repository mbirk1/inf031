class Bill {
    private double totalPrice;
    private double getTotalPrice(){
        return totalPrice;
    }
    public String toString(){

        return null;
    }
}
class BillItem{

}
interface CarComponent{
    public String getName();
}
final class Car implements CarComponent{

    @Override
    public String getName() {
        return null;
    }
}
class CarPart implements CarComponent{

    @Override
    public String getName() {
        return null;
    }
    class Motor{

    }
    class Wheel{

    }
    class Seat{

    }
}
