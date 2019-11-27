package main;

import characters.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    private final String outputFile;

    public Writer(final String outputFile) {
        this.outputFile = outputFile;
    }

    public void writeToFile(final List<Hero> heroes) throws IOException {
        FileWriter fileWriter = new FileWriter(this.getOutputFile());
        PrintWriter printWriter = new PrintWriter(this.getOutputFile());
        for (Hero hero : heroes) {
            printWriter.println(hero);
        }
        printWriter.close();
    }

    public String getOutputFile() {
        return outputFile;
    }

}
