package cardGame;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
		private ArrayList<Card> cards;
		
	

	public Deck() {
    this.cards = new ArrayList<Card>();
	}
	
	public void createDeck() {
		for(Suit cardSuit : Suit.values()) {
			for(Value cardValue : Value.values()) {
				//Add new card
				this.cards.add(new Card(cardSuit,cardValue));
			}
		}
	}
	public void shuffle() {
	ArrayList<Card> tempDeck = new ArrayList<Card>();
	Random random = new Random();
	int randomCardIndex = 0;
	int originalSize = this.cards.size();
	for(int i = 0; i < originalSize; i++) {
		randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
		tempDeck.add(this.cards.get(randomCardIndex));
		//Remove card from deck
		this.cards.remove(randomCardIndex);
	}
	   this.cards = tempDeck;
	}
	
	

public String toString() {
	String cardListOutput = "";
	
	for (Card aCard : this.cards) {
		cardListOutput += "\n" + aCard.toString();
		
	}
	return cardListOutput;
	
	}

	public void removeCard(int i) {
		this.cards.remove(i);
	}
	public Card getCard(int i) {
		return this.cards.get(0);
	}
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	//Draws from the deck
    public void draw (Deck drawFrom) {
    	this.cards.add(drawFrom.getCard(0));
        drawFrom.removeCard(0);
    }
    
    public void moveBackToDeck(Deck moveTo) {
    	int thisDecksize = this.cards.size();
    	
    	for(int i = 0; i < thisDecksize; i++) {
    		moveTo.addCard(this.getCard(i));
    }
    	for(int i = 0; i < thisDecksize; i++) {
    		this.removeCard(i);
    	}
    	}
    
    
    
    public int cardsValue() {
    int totalValue = 0;
    int aces = 0;
    
    for (Card aCard : this.cards) {
    	switch(aCard.getValue()) {
    	case Two: totalValue += 2; break;
    	case Three: totalValue += 3; break;
    	case Four: totalValue += 4; break;
    	case Five: totalValue += 5; break;
    	case Six: totalValue += 6; break;
    	case Seven: totalValue += 7; break;
    	case Eight: totalValue += 8; break;
    	case Nine: totalValue += 9; break;
    	case Ten: totalValue += 10; break;
    	case Jack: totalValue += 10; break;
    	case Queen: totalValue += 10; break;
    	case King: totalValue += 10; break;
    	case Ace: totalValue += 1; break;
    	
    	}
    	}
    for(int i = 0; i < aces; i++) {
    	if(totalValue > 10) {
    		totalValue += 1;
    	}
    	else {
    		totalValue += 11;
    	}
    }
    return totalValue;
    }

	public int deckSize() {
		
		return this.cards.size();
	}
    }
    
	


