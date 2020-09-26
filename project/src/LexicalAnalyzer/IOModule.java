package LexicalAnalyzer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
/**
 * This is the IO module that receives input file
 * as well as receives errors from package
 * classes for the Lexical analyzer package
 *
 * @author  Derek Trom
 * @author Elena Corpus
 * @version 1.0
 * @since   2020-09-26
 */


public class IOModule {
    /**
     * Create variables for the input text
     * as well as an ArrayList structure for
     * the matches generated
     */
    private String programText = "";
    private List<Match> matches = new ArrayList<Match>();
    /**
     * <p>
     * This method is used to retrieve file and create a buffer
     * to be analyzed
     * @throws Exception error reading the file contents
     * @param fileName This is the input filename from the command line
     *
     */
    public IOModule (String fileName) throws Exception{

        /**
         * Try to construct and read from the input file
         * and throw an exception if it fails.
         */
        try {
            /**
             * Create File structure and a BufferedReader
             */
            File pascalInput = new File(fileName);
            BufferedReader rdr = new BufferedReader(new FileReader(pascalInput));
            String currentLine = "";

            while (rdr.ready()) {
                currentLine = rdr.readLine();
                programText += currentLine+"\n";
            }
            programText = programText.trim();
            rdr.close();
        } catch (Exception e) {
            System.err.println("There was a problem reading the file.");
            System.err.println(e.getMessage());
            System.exit(1);
        }

        /**
         * Adds headers for the printable table in list
         */
        this.addMatch(new LexicalAnalyzer.Match("LEXEME","SPELLING"));
        this.addMatch(new LexicalAnalyzer.Match("",""));
    }
    /**
     * Used to return the text
     * @return Returns the programText read from the input file
     */
    public String getProgramText() {
        return programText;
    }
    /**
     * Adds a symbol match to the matches list
     * @param newMatch match to be added to the list
     */
    public void addMatch(Match newMatch) {
        matches.add(newMatch);
    }

    /**
     * Prints out the matches in the list
     * generated from the program
     */
    public void printMatches() {
        System.out.println();
        for (Match m : matches) {
            System.out.println(m);
        }
    }
}
