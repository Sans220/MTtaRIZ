public class Lab3_GameField {
private char[][] field = new char[3][3];

    public Lab3_GameField() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = '-';
    }

    public void printField() {
        System.out.println("Поле:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellFree(int x, int y) {
        return field[x][y] == '-';
    }

    public void setCell(int x, int y, char symbol) {
        field[x][y] = symbol;
    }

    // результат: 1 – победа X, 2 – победа O, 0 – нет победы
    public int checkWin() {
        // проверка строк
        for (int i = 0; i < 3; i++)
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != '-')
                return field[i][0] == 'X' ? 1 : 2;

        // проверка колонок
        for (int i = 0; i < 3; i++)
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[0][i] != '-')
                return field[0][i] == 'X' ? 1 : 2;

        // диагонали
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != '-')
            return field[0][0] == 'X' ? 1 : 2;

        if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][2] != '-')
            return field[0][2] == 'X' ? 1 : 2;

        return 0;
    }
}
