
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Biglietteria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Inserisci il numero di km: ");
            int km = input.nextInt();

            System.out.print("Inserisci l'età del passeggero: ");
            int eta = input.nextInt();

            Biglietto biglietto = new Biglietto(km, eta);
            BigDecimal prezzo = biglietto.calcolaPrezzo();

            System.out.println("Il prezzo del biglietto è: " + prezzo + " €");
        } catch (InputMismatchException e) {
            System.out.println("Inserisci un valore valido per km e età.");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}




