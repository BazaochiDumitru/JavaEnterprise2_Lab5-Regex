import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Creează un obiect Scanner pentru a citi datele de la intrare
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Apelează metoda menu() pentru a afișa un meniu și a permite utilizatorului să aleagă o opțiune
        menu();
    }

    // Metoda pentru căutarea unui număr de telefon în text
    public static void Number() {
        // se definește un șir de caractere numit "inputString", care conține textul în care se va căuta un număr de telefon
        String inputString = "Acesta e un numar de telefon pentru verificare +37368123456";
        // Se definește un șablon (pattern) pentru expresii regulate
        String pattern = "(\\d+)";

        // Se creează un obiect "Pattern" numit "ptrn" prin compilarea șablonului definit anterior
        Pattern ptrn = Pattern.compile(pattern);
        // Se creează un obiect "Matcher" pentru căutarea șabloanelor în text
        Matcher matcher = ptrn.matcher(inputString);

        if (matcher.find()) {
            System.out.println("Numar de telefon: " + matcher.group(0));
        } else {
            System.out.println("Acesta nu e un numar de telefon");
        }
    }

    // Metoda pentru căutarea cuvintelor care încep cu litera 'A' și afișarea lor
    public static void Expes() {
        String text = "Popescu Andrei Alexandru";
        Pattern pattern = Pattern.compile("\\bA\\w*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    // Metoda pentru despartirea textului în cuvinte și afișarea lor
    public static void Expes2() {
        String text = "Buna ziua. Noi testam despartirea textului.";
        Pattern pattern = Pattern.compile("\\s");
        String[] strings1 = pattern.split(text);
        for (String s : strings1) {
            System.out.println(s);
        }
    }

    // Metoda pentru căutarea adreselor de email în text și afișarea lor
    public static void Email() {
        String regex = "(\\w{6,})@(\\w+\\.)([a-z]{2,4})";
        String s = "Acestea sunt cateva adrese de poste electronice cum ar fi bazaochidima@gmail.com si johnathanb@gmail.com!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println("e-mail: " + matcher.group());
        }
    }

    // Metoda pentru înlocuirea cuvântului "calculator" cu "telefon" în text
    public static void repl() {
        String REGEX = "calculator";
        String INPUT = "Acest calculator are un procesor de ultima generatie ";
        String REPLACE = "telefon";
        Pattern p = Pattern.compile(REGEX);

        // Obținem un obiect Matcher pentru potrivirea textului
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }

    // Meniul principal
    private static void menu() {
        //  Inițializarea variabilei num pentru a stoca opțiunea aleasă de utilizator
        int num = -1;
        do {
            System.out.println(" ");
            System.out.println("    Alegeti o optiune ");
            System.out.println("1 - Cautarea numarului de telefon ");
            System.out.println("2 - Cautarea unui simbol anumit ");
            System.out.println("3 - Despartirea textului");
            System.out.println("4 - Cautarea postei electronice");
            System.out.println("5 - Schimbarea unui cuvant");
            System.out.println("0 - Exit ");
            num = sc.nextInt();
            show(num);
        } while (num != 0);
    }

    // Funcția pentru afișarea opțiunii alese de utilizator
    private static void show(int n) {
        switch (n) {
            case 0:
                break;
            case 1:
                Number();
                break;
            case 2:
                Expes();
                break;
            case 3:
                Expes2();
                break;
            case 4:
                Email();
                break;
            case 5:
                repl();
                break;
        }
    }
}
