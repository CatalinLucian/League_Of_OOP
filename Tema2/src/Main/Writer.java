package Main;

import characters.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    private final String outputFile;
    //private final List<Hero> finalTable;

    public Writer(final String outputFile) {
        this.outputFile = outputFile;
      //  this.finalTable = finalTable;
    }

    public void writeToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(this.getOutputFile());
        PrintWriter printWriter = new PrintWriter(this.getOutputFile());
      //  printWriter.println(this.getFinalTable());
        printWriter.println("Merge printarea in fiser");
        printWriter.close();
    }

    public String getOutputFile() {
        return outputFile;
    }

    //public List<Hero> getFinalTable() {
      //  return finalTable;
    //}
}
