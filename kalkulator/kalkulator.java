import java.util.Scanner;

class Kwadrat {
    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public double obliczPole() {
        return bok * bok;
    }
}

class Prostokat {
    private double dlugosc;
    private double szerokosc;

    public Prostokat(double dlugosc, double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    public double obliczPole() {
        return dlugosc * szerokosc;
    }
}

class Trojkat {
    private double podstawa;
    private double wysokosc;

    public Trojkat(double podstawa, double wysokosc) {
        this.podstawa = podstawa;
        this.wysokosc = wysokosc;
    }

    public double obliczPole() {
        return 0.5 * podstawa * wysokosc;
    }
}

public class KalkulatorFigurGeometrycznych {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nWybierz figurę do obliczeń:");
            System.out.println("1. Kwadrat");
            System.out.println("2. Prostokąt");
            System.out.println("3. Trójkąt");
            System.out.println("4. Wyjście");

            System.out.print("\nWybór: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.print("Podaj długość boku kwadratu: ");
                    double bokKwadratu = scanner.nextDouble();
                    Kwadrat kwadrat = new Kwadrat(bokKwadratu);
                    System.out.println("Pole powierzchni kwadratu wynosi: " + kwadrat.obliczPole());
                    break;

                case 2:
                    System.out.print("Podaj długość prostokąta: ");
                    double dlugoscProstokata = scanner.nextDouble();
                    System.out.print("Podaj szerokość prostokąta: ");
                    double szerokoscProstokata = scanner.nextDouble();
                    Prostokat prostokat = new Prostokat(dlugoscProstokata, szerokoscProstokata);
                    System.out.println("Pole powierzchni prostokąta wynosi: " + prostokat.obliczPole());
                    break;

                case 3:
                    System.out.print("Podaj długość podstawy trójkąta: ");
                    double podstawaTrojkata = scanner.nextDouble();
                    System.out.print("Podaj wysokość trójkąta: ");
                    double wysokoscTrojkata = scanner.nextDouble();
                    Trojkat trojkat = new Trojkat(podstawaTrojkata, wysokoscTrojkata);
                    System.out.println("Pole powierzchni trójkąta wynosi: " + trojkat.obliczPole());
                    break;

                case 4:
                    System.out.println("Dziękujemy za skorzystanie z kalkulatora. Do widzenia!");
                    break;

                default:
                    System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }

        } while (wybor != 4);

        scanner.close();
    }
}