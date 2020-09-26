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
    private static int totalMatches = 0;
    private int matchID = 0;
    private String lexeme = "";
    private String token = "";

    // Constructor assigns the token and lexeme,
    // and gives this instance a matchID while
    // incrementing the totalMatches.
    public Match (String token, String lexeme) {
        this.lexeme = lexeme;
        this.token = token;
        this.matchID = ++totalMatches;
    }

    // Match overrides toString for
    // convenient printout.
    @Override
    public String toString() {
        String str = "%-20s %-20s";
        str = String.format(
                str,
                token,
                lexeme
        );
        return str;
    }
}
