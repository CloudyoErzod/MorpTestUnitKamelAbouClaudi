package Model;


public class Plateau {

    public static int[][]Case;

    public Plateau() {

        Case = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {

                Case[i][y] = 0;
            }
        }

    }

    public boolean TestCaseLigne(int i, int y) {
        return true;
    }

    public boolean TestCaseCol(int i, int y) {
        return true;
    }

    public boolean TestCaseDiagonal(int i, int y) {
        return true;
    }
}

