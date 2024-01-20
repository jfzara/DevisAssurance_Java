import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//on crée un scanner pour lire la saisie de l'utilisateur

        String prenom = obtenirValeurString(scanner, "Entrez votre prénom (lettres uniquement): ");
        String nom = obtenirValeurString(scanner, "Entrez votre nom (lettres uniquement): ");
        LocalDate dateNaissance = obtenirDate(scanner, "Entrez votre date de naissance (YYYY-MM-DD) : ");
        String marqueVoiture = obtenirValeurString(scanner, "Entrez la marque de votre voiture (lettres uniquement): ");
        int anneeVoiture = obtenirValeurInt(scanner, "Entrez l'année de votre voiture (nombres uniquement): ");
        int nbAccidents = obtenirValeurInt(scanner, "Entrez le nombre d'accidents (nombres positifs uniquement): ");

        int devis = calculerDevis(50, dateNaissance, marqueVoiture, anneeVoiture, nbAccidents);// on stocke les données saisies dans la variable devis

        afficherDevis(prenom, nom, marqueVoiture, anneeVoiture, devis);// on calcule le devis en affichant les données saisies par l'utilisateur

        scanner.close();
    }

    public static String obtenirValeurString(Scanner scanner, String message) {
        System.out.print(message);//a chaque information demandée, la console affiche un message correspondant disant a l'utilisateur quoi saisir
        return scanner.nextLine().trim();//couper les espaces dans la saisie de l utilisateur pour éviter les bugs
    }

    public static LocalDate obtenirDate(Scanner scanner, String message) {
        System.out.print(message);
        String dateString = scanner.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    public static int obtenirValeurInt(Scanner scanner, String message) {
        int valeur = 0;

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                valeur = scanner.nextInt();

                if (valeur >= 0) {
                    break; // Sort de la boucle si la saisie est un entier positif
                } else {
                    System.err.println("Veuillez saisir un nombre positif.");
                }
            } else {
                System.err.println("Saisie non-numérique. Veuillez saisir un nombre valide.");
                scanner.next();
            }
        }

        return valeur;
    }

    public static int calculerDevis(int prixDeBase, LocalDate dateNaissance, String marqueVoiture,
                                    int anneeVoiture, int nbAccidents) {
        int devis = prixDeBase;


        if (anneeVoiture < 2010) {
            devis -= 20;
        }

        boolean marqueLuxe = marqueVoiture.equals("Mercedes") || marqueVoiture.equals("Porsche") ||
                marqueVoiture.equals("Audi") || marqueVoiture.equals("BMW");
        if (marqueLuxe) {
            devis += 25;
        }

        if (nbAccidents == 0) {
            devis = prixDeBase;
        } else if (nbAccidents == 1) {
            devis += 10;
        } else {
            devis += 20;
        }

        LocalDate currentDate = LocalDate.now();
        if (currentDate.minusYears(25).isBefore(dateNaissance)) {
            devis += 20;
        }

        return devis;
    }

    public static void afficherDevis(String prenom, String nom, String marqueVoiture, int anneeVoiture, int devis) {
        System.out.println(String.format("Bonjour %s %s, nous avons un devis de %d$ pour votre %s %d.",
                prenom, nom, devis, marqueVoiture, anneeVoiture));
    }
}