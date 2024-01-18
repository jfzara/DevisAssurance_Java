import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String prenom, nom, marqueVoiture, codePostal ;
        int nbreAccidents, anneeVoiture;
        double devisBase;

Scanner myScanner = new Scanner(System.in);
System.out.println();
private static String (){

    }

    // Méthode pour obtenir une valeur de type String depuis l'utilisateur
       private static String obtenirValeurString(Scanner scanner, String message){
            System.out.print(message);
            return scanner.nextLine().trim();
        }
        private static LocalDate obtenirDate(Scanner scanner, String message){
            System.out.print(message);
            String dateString = scanner.nextLine().trim();

            try {
                return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));//on parse la date car la saisie est un string
            } catch (Exception e) {
                System.out.println("Format de date incorrect. Veuillez utiliser le format AAAA-MM-JJ.");
                return obtenirDate(scanner, message);
            }
        }

        private static double calculerDevis(int prixDeBase, LocalDate dateNaissance, String){
}
    }
        private static String afficherDevis(String prenom, String nom, String marqueVoiture, int
        anneeVoiture, int devis){

        }
    }