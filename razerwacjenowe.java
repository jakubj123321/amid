import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SzkolnySystemRezerwacji {

    private static Map<String, SalaLekcyjna> saleLekcyjne = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Rezerwacja sali");
            System.out.println("2. Sprawdzenie dostępności sali");
            System.out.println("3. Dodanie sali");
            System.out.println("4. Edycja pojemności sali");
            System.out.println("5. Wyjście");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    rezerwujSale(scanner);
                    break;
                case 2:
                    sprawdzDostepnosc(scanner);
                    break;
                case 3:
                    dodajSale(scanner);
                    break;
                case 4:
                    edytujPojemnosc(scanner);
                    break;
                case 5:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void rezerwujSale(Scanner scanner) {
        System.out.println("Podaj numer sali:");
        String numerSali = scanner.next();

        if (saleLekcyjne.containsKey(numerSali)) {
            SalaLekcyjna sala = saleLekcyjne.get(numerSali);

            System.out.println("Podaj datę (dd.mm.rrrr):");
            String data = scanner.next();

            System.out.println("Podaj godzinę (hh:mm):");
            String godzina = scanner.next();

            if (sala.sprawdzDostepnosc(data, godzina)) {
                sala.zarezerwujSale(data, godzina);
                System.out.println("Rezerwacja udana!");
            } else {
                System.out.println("Sala jest już zajęta w tym terminie.");
            }
        } else {
            System.out.println("Sala o podanym numerze nie istnieje.");
        }
    }

    private static void sprawdzDostepnosc(Scanner scanner) {
        System.out.println("Podaj numer sali:");
        String numerSali = scanner.next();

        if (saleLekcyjne.containsKey(numerSali)) {
            SalaLekcyjna sala = saleLekcyjne.get(numerSali);

            System.out.println("Podaj datę (dd.mm.rrrr):");
            String data = scanner.next();

            System.out.println("Podaj godzinę (hh:mm):");
            String godzina = scanner.next();

            if (sala.sprawdzDostepnosc(data, godzina)) {
                System.out.println("Sala jest dostępna w podanym terminie.");
            } else {
                System.out.println("Sala jest zajęta w podanym terminie.");
            }
        } else {
            System.out.println("Sala o podanym numerze nie istnieje.");
        }
    }

    private static void dodajSale(Scanner scanner) {
        System.out.println("Podaj numer sali:");
        String numerSali = scanner.next();

        if (!saleLekcyjne.containsKey(numerSali)) {
            System.out.println("Podaj pojemność sali:");
            int pojemnosc = scanner.nextInt();

            saleLekcyjne.put(numerSali, new SalaLekcyjna(pojemnosc));
            System.out.println("Sala dodana pomyślnie.");
        } else {
            System.out.println("Sala o podanym numerze już istnieje.");
        }
    }

    private static void edytujPojemnosc(Scanner scanner) {
        System.out.println("Podaj numer sali:");
        String numerSali = scanner.next();

        if (saleLekcyjne.containsKey(numerSali)) {
            System.out.println("Podaj nową pojemność sali:");
            int nowaPojemnosc = scanner.nextInt();

            SalaLekcyjna sala = saleLekcyjne.get(numerSali);
            sala.ustawPojemnosc(nowaPojemnosc);

            System.out.println("Pojemność sali zaktualizowana pomyślnie.");
        } else {
            System.out.println("Sala o podanym numerze nie istnieje.");
        }
    }
}

class SalaLekcyjna {
    private int pojemnosc;
    private Map<String, String> rezerwacje = new HashMap<>();

    public SalaLekcyjna(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public boolean sprawdzDostepnosc(String data, String godzina) {
        String termin = data + " " + godzina;
        return !rezerwacje.containsKey(termin);
    }

    public void zarezerwujSale(String data, String godzina) {
        String termin = data + " " + godzina;
        rezerwacje.put(termin, "Zarezerwowano");
    }

    public void ustawPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }
}
