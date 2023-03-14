import java.util.*;
public class Deck {
    private ArrayList<Card> deck;
    private int size;

    //constructor with no args to return standard 52 card deck
    public Deck() {
        this(Card.Rank.values(), Card.Suit.values());
    }

    //need to do card.rank bc enums are inner class inside card
    public Deck(Card.Rank[] ranks, Card.Suit[] suits) {
        deck = new ArrayList<>();
        for (Card.Suit s : suits) {
            for (Card.Rank r : ranks) {
                deck.add(new Card(r,s));
                size++;
            }
        }
        shuffle();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return deck.get(size);
    }

    public void shuffle() {
        size = 52;
        for (int k = deck.size()-1; k >= 1; k--) {
            int range = (k-0)+1;
            int r = (int) (Math.random()*range);
            Collections.swap(deck, k, r);
        }
    }

    public void perfectShuffle() {
        size = 52;
        Card [] shuffled = new Card[size];
        for (int i=0; i<52; i++) {
            shuffled[i] = deck.get(i);
        }
        int k = 0;
        for (int j=0; j<=25; j++) {
            shuffled[k] = deck.get(j);
            k = k+2;
        }
        k = 1;
        for (int j=26; j<=51; j++) {
            shuffled[k] = deck.get(j);
            k = k+2;
        }
    }

    @Override
    public String toString() {
        String str1 = "";
        
        for (int i=0; i<deck.size(); i++) {
            Card card1 = deck.get(i);
            if (card1.getRank().getPointValue() >= 2 && card1.getRank().getPointValue() <= 10) {
                Integer obj = card1.getRank().getPointValue();
                str1 += obj.toString() + card1.getSuit().toString() + "\n";
            }
            else {
                str1 += card1.getRank().toString() + card1.getSuit().toString() + "\n";
            }
        }
        return str1;
    }

    public static void main(String [] args) {
        Deck deck1 = new Deck();
        deck1.perfectShuffle();
        //testing shuffle algorithm
        // System.out.println (deck1.deal().getRank());
        // System.out.println (deck1.deal().getSuit());

        // while (!deck1.isEmpty()) {
        //     System.out.println (deck1.deal());
        // }

        for (int i=0; i<45; i++) {
            deck1.deal();
        }
        System.out.println (deck1.toString());
    }
}
