package LexicalAnalyzer;
/**
 * This is the main driver class for the
 * Lexical analyzer package
 *
 * @author  Derek Trom
 * @author Elena Corpus
 * @version 1.0
 * @since   2020-09-26
 */
public class Driver {
    private static String fileName = "";
    /**
     * This is Main and where the start
     * of the package is for the Lexical
     * analyzer
     * @param  args get fileName from command line
     * @throws Exception no input file provided
     */
    public static void main (String[] args) throws Exception {

        /**
         * Start of program drives the package
         * Try getting filename from args[]
         * Throws Exception if no program provided
         */
        try {
            fileName = args[0];
        } catch (Exception e) {
            System.err.println("Please provide an input program\n");
            System.exit(1);
        }

        /**
         * Create a new IOModule and give it the file to read
         */

        IOModule io = new LexicalAnalyzer.IOModule(fileName);
        /**
         *Create a new Lexer and give it the programText read in by io
         */
        Lexer lexer = new LexicalAnalyzer.Lexer(io.getProgramText());

        /**
         * Try reading symbols from the lexer
         */
        try {
            /**
             *While the Lexer is ready to read symbols
             * get symbols using Lexer.getsym()
             * @see Lexer
             */
            while (lexer.isReady()) {
                // Get the next symbol from the Lexer
                String symbol = lexer.getsym();
                // If the Lexer didn't find anything, and if it didn't find a COMMENT
                if (!"".equals(symbol) && !LexicalAnalyzer.Language.TOK_LP_COMMENT.equals(lexer.getDetectedToken())) {
                    // Add a new match to IOModule's matches List
                    io.addMatch(new LexicalAnalyzer.Match(lexer.getDetectedToken(),symbol));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        /**
         * Print all matches from the list generated
         */
        io.printMatches();

    }

}
