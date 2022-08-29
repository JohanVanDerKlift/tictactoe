package nl.Novi.TicTacToe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private File scoreFile;
    private FileWriter pen;
    private BufferedWriter printer;

    public FileManager(String scoreFilePath) throws IOException{
        this.scoreFile = new File(scoreFilePath);
        this.pen = new FileWriter(scoreFile);
        this.printer = new BufferedWriter(pen);
    }

    public void writeGameNumber(int gameNumber){
        try {
            printer.write("Spel nummer: " + gameNumber);
            printer.newLine();
        } catch (IOException e){
            System.out.println("Geen toegang tot locatie");
        }
    }

    public void writeToFile(String name, int score){
        try {
            printer.write("Name: " + name + " Score: " + score);
            printer.newLine();

        } catch (IOException e){
            System.out.println("Geen toegang tot locatie");
        }
    }

    public void writeLine(){
        try {
            printer.write("--------------------------");
            printer.newLine();
        } catch (IOException e) {
            System.out.println("Geen toegang tot locatie");
        }
    }

    public void closeFile(){
        try {
            printer.close();
        } catch (IOException e){
            System.out.println("Geen toegang tot locatie");
        }
    }

}
