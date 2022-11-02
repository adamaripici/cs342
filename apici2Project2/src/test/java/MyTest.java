import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyTest {
	Deck deck = new Deck();
	Dealer dealer = new Dealer();
	@Test
	void test() {
		assertEquals("Deck", deck.getClass().getName(), "wrong class name");
	}

	//test size of deck
	@Test
	void sizeOfDeck() {
		assertEquals(52, deck.size(), "wrong size of deck");
	}

	// check if there are any of the same cards
	@Test
	void sameCards() {
		Card d = new Card('D', 1);

	}

	//test that cards are random
	@Test
	void randomCards() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck2.newDeck();

		assert false == deck1.equals(deck2);

	}
	//test deck
	@Test
	void sizeOfNewDeck() {
		Deck deck1 = new Deck();
		assertEquals(52, deck1.size(), "wrong size of deck");
	}

	//test deck
//	@Test
//	void sizeofNewDeck2() {
//		System.out.println("start");
//		Deck deck1 = new Deck();
////		deck1.newDeck();
//		for (int i = 0; i < deck.size(); i ++) {
//			System.out.println(Card());
//		}
////		assertEquals(52, deck1.size(), "wrong size of deck");
//	}
									//***Dealer Tests**//
	@Test
	void dealerName() {
		assertEquals("Dealer", dealer.getClass().getName(), "wrong class name");
	}




}
