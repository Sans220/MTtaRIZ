public class Lab3_Main {
    public static void main(String[] args) {

        Db db = new Db(); // інтегруємо БД

        Lab3_GameField field = new Lab3_GameField();

        Lab3_Player p1 = new Lab3_Player('X');
        Lab3_Player p2 = new Lab3_Player('O');

        // --- ЛОГІНІЗАЦІЯ ---
        while (!p1.inputInfo(db)) {}
        while (!p2.inputInfo(db)) {}

        field.printField();

        Lab3_Player current = p1;
        int moves = 0;

        while (true) {
            current.makeMove(field);
            field.printField();
            moves++;

            int result = field.checkWin();

            if (result == 1) {
                System.out.println("Переміг гравець " + p1.getUsername() + " (" + p1.getSymbol() + ")");
                break;
            }

            if (result == 2) {
                System.out.println("Переміг гравець " + p2.getUsername() + " (" + p2.getSymbol() + ")");
                break;
            }

            if (moves == 9) {
                System.out.println("Нічия!");
                break;
            }

            current = (current == p1) ? p2 : p1;
        }
    }
}
