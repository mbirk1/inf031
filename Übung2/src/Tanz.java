import java.util.ArrayList;

class Dance {
    private String name;
    private String beat;
    private ArrayList figures = new ArrayList();

    public void getFigures() {
        System.out.println(this.figures);

    }

    public void setFigures(String Figures) {
        this.figures.add(Figures);
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

class StandardDance extends Dance {

}

class LatinDance extends Dance {

}

class Figure {
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

class Sequence extends Figure {
    public ArrayList<String> figures = new ArrayList<String>();

    public void setSequence(ArrayList sequence) {
        this.figures = sequence;
    }

    public boolean add(String figure) {
        if (figures.contains(figure)) {
            return false;
        } else {
            figures.add(figure);
            return true;
        }
    }
}