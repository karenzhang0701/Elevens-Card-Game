
public class Card {
    public enum Suit {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }    

    public enum Rank {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(0),
        QUEEN(0),
        KING(0);
    
        private final int pointValue;
        
        private Rank(int pointValue) {
            this.pointValue = pointValue;
        }
    
        public int getPointValue() {
            return pointValue;
        }

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    private Rank rank;
    private Suit suit;

    public Card (Rank initRank, Suit initSuit) {
        this.rank = initRank;
        suit = initSuit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    //automatically has parameter Card this
    //non static method requires object to call it
    //can directly access instance fields of other without getter bc it is type class inside class
    public boolean matches (Card other) {
        return this.getSuit() == other.getSuit() && this.getRank() == other.getRank();
        //can use == to compare enum types
    }

    public void print() {
        if (rank.getPointValue() >= 2 && rank.getPointValue() <= 10) {
            System.out.println (this.rank.getPointValue() + " of " + this.suit.name().toLowerCase());
        }
        else {
            System.out.println ("of");
        }
    }


    @Override
    public String toString() {
        if (rank.getPointValue() >= 2 && rank.getPointValue() <= 10) {
            Integer obj = rank.getPointValue();
            return obj.toString() + suit.toString();
        }
        return rank.toString() + suit.toString();

    }

    public static void main(String [] args) {
        Rank rank1 = Rank.SEVEN;
        Suit suit1 = Suit.SPADES;
        //name() returns identifier of constant
        Card card1 = new Card(rank1, suit1);
        Card card2 = new Card(rank1, suit1);
        card1.print();
        System.out.println (card1.toString());
        System.out.println (card1.getSuit());
        System.out.println (card1.matches(card2));
    }
}