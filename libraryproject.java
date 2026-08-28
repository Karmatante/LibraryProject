import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

//Klass som representerar en bok med tillhörande attribut.
class Book {
    //Lagrar metadata och teknisk information om en enskild bok
    String title;
    String author;
    String isbn;
    String series;
    int year;
    int seriesNumber;
    int pages;
}

public class Library {

    //Statiska konstanter för färgkodning
    private static String BOLD = "\u001B[1m";
    private static String RESET = "\u001B[0m";
    private static String GREEN = "\u001B[32m";
    private static String YELLOW = "\u001B[33m";
    private static String RED = "\u001B[31m";
    private static String BLUE = "\u001B[34m";
    private static String ITALIC = "\033[3m";


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>();

        // Initiering av startdata
        Book book1 = new Book();
        book1.title = "Naked in Death";
        book1.author = "JD Robb";
        book1.isbn = "978-0425148294";
        book1.year = 1995;
        book1.series = "In Death";
        book1.seriesNumber = 1;
        book1.pages = 294;
        books.add(book1);

        Book book2 = new Book();
        book2.title = "Glory in Death";
        book2.author = "JD Robb";
        book2.isbn = "978-0425150983";
        book2.year = 1995;
        book2.series = "In Death";
        book2.seriesNumber = 2;
        book2.pages = 304;
        books.add(book2);

        Book book3 = new Book();
        book3.title = "Immortal in Death";
        book3.author = "JD Robb";
        book3.isbn = "978-0425153786";
        book3.year = 1996;
        book3.series = "In Death";
        book3.seriesNumber = 3;
        book3.pages = 320;
        books.add(book3);

        int choice = 0;

        //Iteration som upprepar koden så länge villkoret är sant
        while (choice != 4) {
            System.out.println(BOLD + GREEN + "==== LIBRARY ====" + RESET);
            System.out.println(BOLD + "1. Print Booklist" + RESET);
            System.out.println(BOLD + "2. Search for Book" + RESET);
            System.out.println(BOLD + "3. Add Book" + RESET);
            System.out.println(BOLD + "4. Close Program" + RESET);

            System.out.println(YELLOW + ITALIC + "Please enter your choice: " + RESET);

            //Ett försöksblock för undantagshantering vid inmatning
            try {
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(BOLD + "==== LIBRARY CONTENT ====" + RESET);
                        printBooklist(books);
                        break;
                    case 2:
                        System.out.println("==== SEARCH ====");
                        searchForBook(books);
                        break;
                    case 3:
                        System.out.println("==== ADD BOOK ====");
                        addBook(books);
                        break;
                    case 4:
                        System.out.println("==== CLOSE PROGRAM ====");
                        closeProgram(books);
                        break;
                    default:
                        //Hanterar ogiltiga menyval
                        System.out.println(BOLD + RED + "Invalid choice! Please select option 1, 2, 3 or 4." + RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(BOLD + RED + "Error: Please enter a number between 1 and 4." + RESET);
                input.nextLine();
                choice = 0;
            }
        }
    }

    //Skriver ut alla böcker i biblioteket med formaterad layout.
    public static void printBooklist(ArrayList<Book> books) {

        System.out.println(BOLD + GREEN + "Book titles found in this library: " + RESET + YELLOW + books.size() + RESET);

        for (Book currentBook : books) {
            System.out.println(BOLD + BLUE + currentBook.title + RESET + " by " + RED + ITALIC + currentBook.author + ". " + RESET);
            System.out.println(BOLD + ITALIC + "This is book #" + currentBook.seriesNumber + " in the " + currentBook.series + "-series." + RESET + "\n");
        }
    }

    // Söker efter en bok baserat på en söksträng mot titeln.
    public static void searchForBook(ArrayList<Book> books) {

        Scanner input = new Scanner(System.in);
        boolean searching = true;

        while (searching) {
            System.out.println(GREEN + BOLD + "What book are you looking for?" + RESET);
            String searchTerm = input.nextLine();
            boolean found = false;

            //Jämför sökord med alla boktitlar
            for (Book currentBook : books) {
                if (currentBook.title.toLowerCase().contains(searchTerm.toLowerCase())) {
                    System.out.println("Success! Book found: ");
                    System.out.println(BOLD + BLUE + currentBook.title + " by " + RED + currentBook.author + "." + RESET);
                    System.out.println("Published in " + currentBook.year + ".");
                    System.out.println("This is book # " + currentBook.seriesNumber + " in the " + currentBook.series + "-series.");
                    found = true;

                    System.out.println(BOLD + "\nPress Enter to return to menu..." + RESET);
                    input.nextLine();
                    searching = false;
                    break;
                }
            }
            //Om ingen bok hittats
            if (!found) {
                System.out.println(RED + "No book matching '" + searchTerm + "' was found." + RESET);
                System.out.println(GREEN + BOLD + "Do you want to try again? (Yes/No)" + RESET);

                String answer = input.nextLine();

                if (answer.equalsIgnoreCase("No")) {
                    searching = false;
                }
            }
        }
    }

    //Skapar ett nytt Book-objekt via användarinmatning och lägger till det i listan.
    public static void addBook(ArrayList<Book> books) {
        Scanner input = new Scanner(System.in);
        Book newBook = new Book();

        System.out.println(BOLD + BLUE + "TITLE: ");
        newBook.title = input.nextLine();

        System.out.println(BOLD + BLUE + "AUTHOR: ");
        newBook.author = input.nextLine();

        System.out.println(BOLD + BLUE + "ISBN: ");
        newBook.isbn = input.nextLine();

        // Loop för YEAR
        while (true) {
            try {
                System.out.println(BOLD + BLUE + "YEAR: ");
                newBook.year = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(BOLD + RED + "Error: Invalid year. Use numbers." + RESET);
                input.nextLine();
            }
        }

        System.out.println(BOLD + BLUE + "SERIES: ");
        newBook.series = input.nextLine();

        // Loop för SERIES NUMBER
        while (true) {
            try {
                System.out.println(BOLD + BLUE + "SERIES NUMBER: ");
                newBook.seriesNumber = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(BOLD + RED + "Error: Invalid number. Use numbers." + RESET);
                input.nextLine();
            }
        }

        // Loop för PAGES
        while (true) {
            try {
                System.out.println(BOLD + BLUE + "PAGES: ");
                newBook.pages = input.nextInt();
                input.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(BOLD + RED + "Error: Invalid page count. Use numbers." + RESET);
                input.nextLine();
            }
        }

        books.add(newBook);
        System.out.println(GREEN + "Book successfully added to library!" + RESET);
        System.out.println(BOLD + RED + "\nPress Enter to continue..." + RESET);
        input.nextLine();
    }

    //Avslutar programmet
    public static void closeProgram(ArrayList<Book> books) {

        System.out.println(BOLD + RED + "Closing the Library System... Goodbye!" + RESET);
        System.exit(0);
    }
}

/* Dokumentation och utvärdering
1. Dokumentation
Beskrivning av programmet:
Programmet "Library" är ett system för att hantera en boksamling via en textmeny.
Det låter användaren se vilka böcker som finns lagrade, söka efter specifika titlar
och lägga till helt nya böcker i listan under körning.

Teknisk uppbyggnad:
Datastruktur: Jag har skapat en klass som heter Book. Den fungerar som en mall för
att hålla ihop information om varje bok (titel, författare, sidantal etc.).
Alla böcker sparas i en ArrayList, vilket gör att listan kan växa när användaren
lägger till nya böcker.

Logik: Programmet styrs av en while-loop som visar en meny. Beroende på användarens
val (1-4) körs olika metoder som sköter utskrift, sökning eller tillägg av data.

Utskrift: Jag har använt ANSI-koder (som \u001B[32m) för att färgkoda texten,
vilket gör det lättare att skilja på rubriker, felmeddelanden och bokdetaljer.

Kända buggar och felhantering:
Sifferkontroll: Programmet har inbyggd hantering för om användaren råkar skriva
bokstäver när programmet förväntar sig siffror (t.ex. vid val i menyn eller
inmatning av år). Detta löses med try-catch så att programmet inte kraschar.

Sökbegränsning: Just nu avbryts sökningen så fort programmet hittar en bok som
matchar titeln. Om flera böcker har liknande namn visas bara den första träffen.
Jag har inte förstått än hur jag kan fixa denna begränsning än.

Tomma fält: Det går att lägga till en bok utan att skriva in någon titel
eller författare (om man bara trycker Enter), vilket kan leda till tomma rader
i boklistan.

2. Utvärdering
Funktionalitet och användarvänlighet:
Programmet är lätt att förstå tack vare den numrerade menyn och färgerna som
guidar användaren. En tydlig styrka är att programmet ger tydliga felmeddelanden
om man matar in fel typ av data, istället för att bara stängas ner.

Förbättringsförslag:

Radera böcker: En naturlig vidareutveckling vore att lägga till ett menyval
för att kunna ta bort en bok ur listan om den inte längre ska finnas kvar.

Spara data: Just nu nollställs biblioteket varje gång programmet stängs.
En stor förbättring vore att kunna spara ner listan till en fil på datorn.

Utökad sökning: Jag skulle vilja ändra sökfunktionen så att den skriver ut
alla böcker som matchar sökordet, inte bara den första den hittar.

Reflektion:
Jag är hyfsat nöjd med hur jag delat upp koden i olika metoder. Det gör main-metoden
kort och överskådlig. Om jag skulle göra om uppgiften hade jag lagt lite mer
tid på att kontrollera att användaren faktiskt skriver in text (och inte bara
trycker Enter) när en ny bok skapas, för att säkerställa att biblioteket inte
fylls med "tomma" böcker.
 */
