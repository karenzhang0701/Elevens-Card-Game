import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;

    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE);
    }

    /*
     * Note:
     * Before you write any new methods, recall that you can use all the
     * non-abstract
     * public methods in the Board class.
     * You cannot access the private instance variables from the Board class, but
     * with
     * the available public methods, you shouldn't need to. If you think you do,
     * think
     * of a way to avoid it!
     * It is possible to complete the project without implementing any methods
     * other than those here, but if you think that something should be added so the
     * code
     * is clearer, feel free to do so.
     */

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * 
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */

    // selectedCards represents an index in the array cards (from board class)
    // need to use cardAt method to retrieve Card object
    public boolean isLegal(List<Integer> selectedCards) {
        // TODO: implement isLegal
        if (containsPairSum11(selectedCards) || containsJQK(selectedCards)) {
            return true;
        }
        return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * 
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible() {
        // TODO: implement anotherPlayIsPossible
        List<Integer> cardIndexes = cardIndexes();
        // returns indexes of the actual (non-null) cards on the board
        if (containsPairSum11(cardIndexes) || containsJQK(cardIndexes)) {
            return true;
        }
        return false;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * 
     * @param selectedCards selects a subset of this board. It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *         contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        // TODO: implement containsPairSum11
        for (int i = 0; i < selectedCards.size(); i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {
                Card one = cardAt(selectedCards.get(i));
                Card two = cardAt(selectedCards.get(j));
                if (one.getRank().getPointValue() + two.getRank().getPointValue() == 11) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * 
     * @param selectedCards selects a subset of this board. It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *         include a jack, a queen, and a king; false otherwise.
     */
    private boolean isJQK(Card card) {
        return card.getRank().toString().equals("jack") || card.getRank().toString().equals("queen") || card.getRank().toString().equals("king");
    }

    private String rank(Card card) {
        return card.getRank().toString();
    }

    private boolean containsJQK(List<Integer> selectedCards) {
        // TODO: implement containsJQK
        for (int i = 0; i < selectedCards.size(); i++) {
            for (int j = i + 1; j < selectedCards.size(); j++) {
                for (int k = j + 1; k < selectedCards.size(); k++) {
                    Card one = cardAt(selectedCards.get(i));
                    Card two = cardAt(selectedCards.get(j));
                    Card three = cardAt(selectedCards.get(k));
                    if ((isJQK(one) && isJQK(two) && isJQK(three)) && 
                    (!rank(one).equals(rank(two)) && !rank(one).equals(rank(three)) && !rank(two).equals(rank(three)))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
