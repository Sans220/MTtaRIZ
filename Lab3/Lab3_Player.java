import java.util.Scanner;

public class Lab3_Player {
private String name;
    private char symbol;

    public Lab3_Player(char symbol) {
        this.symbol = symbol;
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть ім'я гравця (" + symbol + "): ");
        name = sc.nextLine();
    }

    public void printInfo() {
        System.out.println("Гравець: " + name + " (" + symbol + ")");
    }

    public void makeMove(Lab3_GameField field) {
        Scanner sc = new Scanner(System.in);
        int x, y;

        while (true) {
            System.out.print(name + " (" + symbol + "), введіть рядок і стовпчик (0-2 0-2): ");
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

    public char getSymbol() {
        return symbol;
    }
}
