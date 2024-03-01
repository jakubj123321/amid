import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseManager {

    private Connection connection;
    private BufferedReader reader;

    public static void main(String[] args) {
        DatabaseManager manager = new DatabaseManager();
        manager.runConsoleInterface();
    }

    private void runConsoleInterface() {
        connectToDatabase();
        reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Utworz tabele");
            System.out.println("2. Dodaj rekordy");
            System.out.println("3. Wyszukaj");
            System.out.println("4. Wyjdz");

            try {
                System.out.print("wybierz: ");
                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        createTable();
                        break;
                    case "2":
                        addRecords();
                        break;
                    case "3":
                        search();
                        break;
                    case "4":
                        System.out.println("Wychodzenie...");
                        return;
                    default:
                        System.out.println("Zly wybor, sprobuj ponownie.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void connectToDatabase() {
        try {
            // Replace below parameters with your database credentials
            String url = "jdbc:mysql://localhost:3306/nazwa_bazy";
            String username = "your_username";
            String password = "your_password";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws IOException {
        try {
            System.out.println("wpisz nazwe tabeli:");
            String tableName = reader.readLine();

            System.out.println("wpisz nazwe kolumny:");
            String columnName = reader.readLine();

            System.out.println("typ danych kolumny:");
            String columnType = reader.readLine();

            System.out.println("czy to primary key? (t/n)");
            boolean isPrimaryKey = reader.readLine().equalsIgnoreCase("t");

            System.out.println("auto-incremented? (t/n)");
            boolean isAutoIncrement = reader.readLine().equalsIgnoreCase("t");

            StringBuilder queryBuilder = new StringBuilder("CREATE TABLE " + tableName + " (");
            queryBuilder.append(columnName).append(" ").append(columnType);
            if (isPrimaryKey) {
                queryBuilder.append(" PRIMARY KEY");
                if (isAutoIncrement) {
                    queryBuilder.append(" AUTO_INCREMENT");
                }
            }
            queryBuilder.append(")");

            String query = queryBuilder.toString();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("tabela stworzona pomyslnie.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecords() throws IOException {
        // Implement code for adding records to the database
    }

    private void search() throws IOException {
        // Implement code for searching records in the database
    }
}
