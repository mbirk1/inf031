import java.util.ArrayList;
class Dance {
    private String name;
    private String beat;
    private Object[] figures = new Object[3];

    public Object[] getFigures() {
        return figures;
    }

    public void setFigures(Object[] figures) {
        for(int i = 0; i< figures.length; i++){
            this.figures[i] = figures[i];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }
}
class StandardDance extends Dance{

}
class LatinDance extends Dance{

}
class Figure{
    private String name;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
class Sequence extends Figure{
    private String name;
    public ArrayList<Object> figures = new ArrayList<Object>();
    public void setSequence(ArrayList sequence){
        this.figures = sequence;
    }
    public boolean add(Figure figure){
        if( figure instanceof Sequence){
            return false;
        }
        else{
            figures.add(figure);
            return true;
        }
    }
}