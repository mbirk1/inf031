import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DanceDatabase {
    public static void main(String[] args) {
        Figure Righturn = new Figure();
        Righturn.setName("Rightturn");
        Righturn.setText("Turning right");

        Figure Circle = new Figure();
        Circle.setName("Circle");
        Circle.setText("Circle");

        Figure Whisk = new Figure();
        Whisk.setName("Whisk");

        Figure Chasse = new Figure();
        Chasse.setName("Chassé");
        Chasse.setText("Chassé");

        Figure Fan = new Figure();
        Fan.setText("Fan");
        Fan.setName("Fan");

        Figure Basic = new Figure();
        Basic.setName("Basic Movement");
        Basic.setText("Basic Movement");

        Figure Promenade = new Figure();
        Promenade.setText("Promenade");
        Promenade.setName("Promenade");

        Sequence S_Whisk = new Sequence();
        if(S_Whisk.add(Chasse)){
            System.out.println("Hinzufügen erfolgreich");
            //Um diese Prüfung zu realisieren musste das Objekt Array auf eine Object ArrayList geändert werden, in dem die Figuren
            //gespeichert werden.
        }
        else{
            System.out.println("Hinzufügen nicht erfolgreich");

        }
        StandardDance Walzer = new StandardDance();
        Walzer.setName("Walzer");
        Walzer.setBeat("3/4");
        Object[] figures = new Object[]{Righturn, Circle, Whisk};
        Walzer.setFigures(figures);
        figures = null;

        StandardDance Tango = new StandardDance();
        Tango.setBeat("4/4");
        Tango.setName("Tango");
        figures= new Object[]{Basic, Promenade};
        Tango.setFigures(figures);
        figures= null;

        StandardDance Quickstep = new StandardDance();
        Tango.setBeat("4/4");
        Tango.setName("Quickstep");
        figures = new Object[]{Basic, Circle};
        Tango.setFigures(figures);
        figures= null;

        LatinDance Cha = new LatinDance();
        Cha.setBeat("4/4");
        Cha.setName("ChaChaCha");
        figures = new Object[]{Basic, Fan};
        Cha.setFigures(figures);
        figures= null;

        LatinDance Rumba = new LatinDance();
        Rumba.setBeat("4/4");
        Rumba.setName("Rumba");
        figures = new Object[]{Basic, Fan};
        Cha.setFigures(figures);
        figures= null;

        LatinDance Jive = new LatinDance();
        Jive.setBeat("4/4");
        Jive.setName("ChaChaCha");
        figures = new Object[]{Basic};
        Jive.setFigures(figures);
        figures= null;
    }
}
