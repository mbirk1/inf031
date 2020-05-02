import java.util.ArrayList;

public class DanceDatabase {
    public static void main(String[] args) {
        ArrayList<String> Figures = new ArrayList<String>();
        Figures.add("Rightturn");
        Figures.add("Basic Movement");
        Figures.add("Spin Turn");
        Figures.add("Promenade");
        Figures.add("Chasse");
        Figures.add("Fan");
        Figures.add("Whisk");

        Sequence S_Whisk = new Sequence();
        if (S_Whisk.add("Chasse")) {
            System.out.println("Hinzufügen erfolgreich");
            //Um diese Prüfung zu realisieren musste das Objekt Array auf eine Object ArrayList geändert werden, in dem die Figuren
            //gespeichert werden.
        } else {
            System.out.println("Hinzufügen nicht erfolgreich");
        }
        if (S_Whisk.add("Promenade")) {
            System.out.println("Hinzufügen erfolgreich");
            //Um diese Prüfung zu realisieren musste das Objekt Array auf eine Object ArrayList geändert werden, in dem die Figuren
            //gespeichert werden.
        } else {
            System.out.println("Hinzufügen nicht erfolgreich");
        }
        StandardDance Walzer = new StandardDance();
        Walzer.setName("Walzer");
        Walzer.setBeat("3/4");
        Walzer.setFigures(Figures.get(0));
        Walzer.setFigures(Figures.get(2));
        Walzer.setFigures(Figures.get(6));

        StandardDance Tango = new StandardDance();
        Tango.setBeat("4/4");
        Tango.setName("Tango");
        Tango.setFigures(Figures.get(1));
        Tango.setFigures(Figures.get(3));

        StandardDance Quickstep = new StandardDance();
        Quickstep.setBeat("4/4");
        Quickstep.setName("Quickstep");
        Quickstep.setFigures(Figures.get(1));
        Quickstep.setFigures(Figures.get(2));

        LatinDance Cha = new LatinDance();
        Cha.setBeat("4/4");
        Cha.setName("ChaChaCha");
        Cha.setFigures(Figures.get(1));
        Cha.setFigures(Figures.get(5));

        LatinDance Rumba = new LatinDance();
        Rumba.setBeat("4/4");
        Rumba.setName("Rumba");
        Rumba.setFigures(Figures.get(1));
        Rumba.setFigures(Figures.get(5));

        LatinDance Jive = new LatinDance();
        Jive.setBeat("4/4");
        Jive.setName("ChaChaCha");
        Jive.setFigures(Figures.get(1));
    }

    public void method() {
    }
}
