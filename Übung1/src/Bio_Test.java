
public class Bio_Test {
    public static void main(String[] args){
        Pflanzen_Tiere.Pflanzen Gras = new Pflanzen_Tiere.Pflanzen();
        Gras.setBeschreibung("Gras ist Grün");

        Pflanzen_Tiere.Pflanzen Beeren = new Pflanzen_Tiere.Pflanzen();
        Beeren.setBeschreibung("Beeren sind rot");

        Pflanzen_Tiere.Tiere Zebra = new Pflanzen_Tiere.Tiere();
        Zebra.setName("Zebra");
        Zebra.setPf_futter("Gras");


        Pflanzen_Tiere.Tiere Löwen = new Pflanzen_Tiere.Tiere();
        Löwen.setName("LÖwen");
        Löwen.setF_futter("Zebras");

        Pflanzen_Tiere.Tiere Bären = new Pflanzen_Tiere.Tiere();
        Bären.setName("Bären");
        Bären.setPf_futter("Beeren");
        Bären.setF_futter("Fische");

        Zebra.ausgabe();
        Löwen.ausgabe();
        Bären.ausgabe();
    }
}