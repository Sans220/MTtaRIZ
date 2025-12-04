import java.util.Scanner;

public class Lab3_Player {
    private String username;
    private char symbol;

    public Lab3_Player(char symbol) {
        this.symbol = symbol;
    }

    public boolean inputInfo(Db db) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть логін гравця (" + symbol + "): ");
        username = sc.nextLine();

        System.out.print("Введіть пароль гравця (" + symbol + "): ");
        String password = sc.nextLine();

        // Перевірка в БД
        if (db.isUserExists(username, password)) {
            System.out.println("Успішний вхід!");
            return true;
        } else {
            System.out.println("Невірний логін або пароль! Спробуйте знову.");
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Lab3_GameField field) {
        Scanner sc = new Scanner(System.in);
        int x, y;

        while (true) {
            System.out.print(username + " (" + symbol + "), введіть рядок і стовпчик (0-2 0-2): ");
            x = sc.nextInt();
            y = sc.nextInt();

            if (field.isCellFree(x, y)) {
                field.setCell(x, y, symbol);
                break;
            } else {
                System.out.println("Клітинка зайнята! Спробуйте іншу.");
            }
        }
    }
}
