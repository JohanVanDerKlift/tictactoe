package nl.Novi.TicTacToe;

public class Field {

    private String token;
    private boolean isOccupied;

    public Field(String token) {
        this.token = token;
        this.isOccupied = false;
    }

    public void setToken(String token){
        if (!isOccupied) {
            this.token = token;
        }
        isOccupied = true;
    }

    public String getToken() {
        return token;
    }
}
