package nl.Novi.TicTacToe;

public class Board {

    private Field[] field;
    public Board() {
        this.field = new Field[9];

        for (int i=0; i<9; i++) {
            field[i] = new Field(Integer.toString(i+1));
        }
    }

    public Field[] getField() {
        return field;
    }

    public void printBoard() {
        for (int i=0; i< field.length;i++) {
            System.out.print(field[i].getToken());

            boolean isEndOfRow = (i+1) % 3 == 0;

            if (i+1 == 9) {
                break;
            } else if (isEndOfRow){
                System.out.println("\n__________");
            } else {
                System.out.print(" | ");
            }
        }
    }

    public void setField(int selectedField, String token){
        field[selectedField].setToken(token);
    }
}
