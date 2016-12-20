import java.util.Collection;
import java.util.List;

/**
 * Created by afischer on 15/12/2016.
 */
public class SimpleExample {

    public void simple() {


        Player player = new Player();
        player.name = "Michael Mittendrin"; // schlechter Stil mit Zeiger auf public Variable zu arbeiten (besser getter und setter)

        Pocket<String> stringPocket1 = new Pocket<>(); // Parametrisierter Typ, String ist der Typparameter
        stringPocket1.setValue("Schlüssel");
        player.leftPocket =  stringPocket1; // warum brauche ich hier kein getValue()???

        // kürzer
        Pocket<String> stringPocket2 = new Pocket<>("Portemonnaie");
        player.rightPocket = stringPocket2;


        System.out.println(player.name + " hat in der linken Tasche einen " +
                player.leftPocket + " und in der rechten Tasche das " + player.rightPocket + ".");

        // richtig kurz
        player.leftPocket = new Pocket<>(1111111l);  // neue anonyme Instanz, der Typparameter darf beliebigen Typs sein

        player.rightPocket = new Pocket<>(22222222L);


        Long val1 = (Long) player.leftPocket.getValue();  // left- und rightPocket sind vom Datentyp Pocket und
        Long val2 = (Long) player.rightPocket.getValue(); // können deswegen getValue() aufrufen

        System.out.println(player.name + " hat in der linken Tasche einen " +
                player.leftPocket + " und in der rechten Tasche das " + player.rightPocket + ".");

        System.out.println(val1.compareTo(val2) > 0 ? "Links" : "Rechts");  // wenn val1 > 0 dann "Links" sonst "Rechts"


    }

}
