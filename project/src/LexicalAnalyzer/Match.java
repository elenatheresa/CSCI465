package LexicalAnalyzer;
/**
 * Match
 *
 * This is the match class and provides a
 * constructor for the matches found.
 *
 * @author  Derek Trom
 * @author Elena Corpus
 * @version 1.0
 * @since   2020-09-26
 */
public class Match {
    /**
     * Create variables for the int totalMatches,
     * int matchID, and String for return values
     */
    private static int totalMatches = 0;
    private int matchID = 0;
    private String lexeme = "";
    private String token = "";

    /**
     * Constructor assigns the token and lexeme,
     * and gives this instance a matchID while
     * incrementing the totalMatches.
     * @param lexeme String for the lexeme
     * @param token String for the token generated
     */
    public Match (String token, String lexeme) {
        this.lexeme = lexeme;
        this.token = token;
        this.matchID = ++totalMatches;
    }

    /**
     * Overridden String method to print in a column format
     * @return str formatted with token and lexeme
     */
    @Override
    public String toString() {
        String str = "%-20s %-20s";
        str = String.format(str, token, lexeme);
        return str;
    }
}
