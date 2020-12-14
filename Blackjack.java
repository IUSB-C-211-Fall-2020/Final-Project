package cardGame;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Blackjack");
		//Create deck
		Deck playingDeck = new Deck();
		playingDeck.createDeck();
		playingDeck.shuffle();
		
		//Player Deck
		Deck playerDeck = new Deck();
		Deck dealerDeck = new Deck();
		
		double playerMoney = 1000.00;
		Scanner userInput = new Scanner(System.in);
		
		while(playerMoney > 0) {
			System.out.println("Your account has $" + playerMoney + ", what is your wager?");
			double playerBet = userInput.nextDouble();
			if (playerBet > playerMoney) {
				System.out.println("You dont' have that much in your account and, you have been asked to leave the table");
				break;
		}
		boolean endRound = false;
		
		
		
		
		playerDeck.draw(playingDeck);
		playerDeck.draw(playingDeck);
		
		dealerDeck.draw(playingDeck);
		dealerDeck.draw(playingDeck);
		
		while(true) {
			System.out.println("Your hand: ");
			System.out.print(playerDeck.toString());
			System.out.println("You have: " + playerDeck.cardsValue());
			
			//Dealer hand
			System.out.println("Dealer has: " + dealerDeck.getCard(0).toString() + " one down card");
			
			System.out.println("Enter (1) to hit or (2) to stay");
			
			int response = userInput.nextInt();
			
			if (response == 1) {
				
				playerDeck.draw(playingDeck);
				System.out.println("You draw an " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
				if(playerDeck.cardsValue() > 21 ) {
					System.out.println("BUST!!" + playerDeck.cardsValue());
					playerMoney -= playerBet;
					
					endRound = true;
				
					break;
					
				}
			}
			if(response == 2) {
			break;	
			}
			}
		//Dealer cards
		System.out.println("Dealer Cards: " + dealerDeck.toString());
		if((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound == false) {
			System.out.println("Dealer wins!!");
			playerMoney -= playerBet;
			endRound = true;
			
		}
		else if(endRound == false) {
			System.out.println("You Lose");
			playerMoney -= playerBet;
			endRound = true;
		}
		
		while((dealerDeck.cardsValue() < 17) && endRound == false) {
			dealerDeck.draw(playingDeck);
			System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			if((dealerDeck.cardsValue() > 21) && endRound == false){
				System.out.println("Dealer busts, you win. ");
				playerMoney += playerBet;
				endRound = true;
				if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
					System.out.println("Push");
					endRound = true;
				}
				if((playerDeck.cardsValue() > dealerDeck.cardsValue())&& endRound == false) {
					System.out.println("You win!!");
					playerMoney += playerBet;
					endRound = true;
				}
				playerDeck.moveBackToDeck(playingDeck);
				dealerDeck.moveBackToDeck(playingDeck);
				System.out.println("End of game");
			}
			}
		}
		}
			}
		

	


