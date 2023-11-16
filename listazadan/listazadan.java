import java.util.ArrayList;
import java.util.Scanner;

class Zadanie {
    private String nazwa;
    private String opis;
    private boolean czyZakonczone;

    public Zadanie(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.czyZakonczone = false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public boolean isCzyZakonczone() {
        return czyZakonczone;
    }

    public void oznaczJakoZakonczone() {
        czyZakonczone = true;
    }
}

public class ToDoList {
    private static ArrayList<Zadanie> listaZadan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int wybor;

        do {
            wyswietlMenu();
            System.out.print("Wybierz opcję (1/2/3/4/5): ");
            wybor = scanner.nextInt();
            scanner.nextLine(); // konsumowanie znaku nowej linii

            switch (wybor) {
                case 1:
                    dodajZadanie();
                    break;
                case 2:
                    oznaczZadanieJakoZakonczone();
                    break;
                case 3:
                    usunZadanie();
                    break;
                case 4:
                    wyswietlListeZadan();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }

        } while (wybor != 5);

        scanner.close();
    }

    private static void wyswietlMenu() {
        System.out.println("\n1. Dodaj nowe zadanie");
        System.out.println("2. Oznacz zadanie jako zakończone");
        System.out.println("3. Usuń zadanie");
        System.out.println("4. Wyświetl listę zadań");
        System.out.println("5. Wyjście");
    }

    private static void dodajZadanie() {
        System.out.print("Podaj nazwę zadania: ");
        String nazwa = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String opis = scanner.nextLine();

        Zadanie noweZadanie = new Zadanie(nazwa, opis);
        listaZadan.add(noweZadanie);

        System.out.println("Zadanie \"" + nazwa + "\" zostało dodane do listy.");
    }

    private static void oznaczZadanieJakoZakonczone() {
        wyswietlListeZadan();

        System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
        int numerZadania = scanner.nextInt();

        if (numerZadania >= 1 && numerZadania <= listaZadan.size()) {
            Zadanie zadanie = listaZadan.get(numerZadania - 1);
            zadanie.oznaczJakoZakonczone();

            System.out.println("Zadanie \"" + zadanie.getNazwa() + "\" zostało oznaczone jako zakończone.");
        } else {
            System.out.println("Niepoprawny numer zadania.");
        }
    }

    private static void usunZadanie() {
        wyswietlListeZadan();

        System.out.print("Podaj numer zadania do usunięcia: ");
        int numerZadania = scanner.nextInt();

        if (numerZadania >= 1 && numerZadania <= listaZadan.size()) {
            Zadanie zadanie = listaZadan.remove(numerZadania - 1);

            System.out.println("Zadanie \"" + zadanie.getNazwa() + "\" zostało usunięte z listy.");
        } else {
            System.out.println("Niepoprawny numer zadania.");
        }
    }

    private static void wyswietlListeZadan() {
        System.out.println("Lista zadań:");

        if (listaZadan.isEmpty()) {
            System.out.println("(brak zadań)");
        } else {
            for (int i = 0; i < listaZadan.size(); i++) {
                Zadanie zadanie = listaZadan.get(i);
                String status = zadanie.isCzyZakonczone() ? "[x]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + zadanie.getNazwa() + ": " + zadanie.getOpis());
            }
        }
    }
}