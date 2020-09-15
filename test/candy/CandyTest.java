/*
 * 7 September 2020
 * @author Tishya Khanna
 * This program is to perform JUnit tests for the class Candy
 */

package candy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/*
 * Testing class Candy
 */
class CandyTest {
	//list of likes
	private List<String> likes;

	//list of loves
	private List<String> loves;

	@BeforeEach
	void initialize() {
		/*
		 * Initializing all objects before each test
		 */
		likes = new ArrayList<String>();
		loves = new ArrayList<String>();
	}

	@Test
	void testConstructor() {
		/*
		 * Purpose: Test correct use of constructor
		 * Method: Constructor
		 * Initialization: None
		 * Parameters: "Candy1", ["gelatin", "sugar", "lemons"]
		 * Correct result: getName should return "Candy1"
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons"};
		Candy candy1 = new Candy("Candy1", ingredients);
		assertEquals ("Candy1", candy1.getName());
	}

	@Test
	void testConstructor2() {
		/*
		 * Purpose: Test correct use of constructor
		 * Method: Constructor
		 * Initialization: None
		 * Parameters: "", [""]
		 * Correct result: getName should return ""
		 */
		String[] ingredients = {};
		Candy candy1 = new Candy("", ingredients);
		assertEquals ("", candy1.getName());
	}

	@Test
	void testScore() {
		/*
		 * Purpose: What happens when desired ingredients have some 
		 * intersects with our candy
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients gelatin, 
		 * sugar, lemons, cherry, chocolate
		 * Parameters: pass in the lists: likes={"marshmallows", "chocolate", "sugar"}, 
		 * loves = {"gelatin","lemons"}
		 * Correct Result: 12
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons", "cherry", "chocolate"};
		Candy candy1 = new Candy("Candy1", ingredients);
		likes.add("marshmallows");
		likes.add("chocolate");
		likes.add("sugar");
		loves.add("gelatin");
		loves.add("lemons");

		assertEquals (12, candy1.score(likes, loves));
	}

	@Test
	void testScore2() {
		/*
		 * Purpose: What happens when desired ingredients have no 
		 * intersection with our candy
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients 
		 * gelatin, sugar, lemons
		 * Parameters: pass in the lists: likes = {"marshmallows", "chocolate"}, 
		 * loves = {"cars","buses"}
		 * Correct Result: 0
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons"};
		Candy candy1 = new Candy("Candy1", ingredients);
		likes.add("marshmallows");
		likes.add("chocolate");
		loves.add("cars");
		loves.add("buses");
		assertEquals (0, candy1.score(likes, loves));
	}

	@Test
	void testScore3() {
		/*
		 * Purpose: testing with empty likes and loves
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients gelatin, 
		 * sugar, lemons
		 * Parameters: pass in an empty list of likes and loves
		 * Correct Result: 0
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons"};
		Candy candy1 = new Candy("Candy1", ingredients);
		assertEquals (0, candy1.score(likes, loves));
	}

	@Test
	void testScore4() {
		/*
		 * Purpose: What does it do to an empty ingredient list as parameter 
		 * and a candy with no ingredients
		 * Method: method score
		 * Initialization: Construct Candy object with no ingredients 
		 * Parameters: pass in an empty list of likes and loves
		 * Correct Result: 0
		 */
		String[] ingredients = {""};
		Candy candy1 = new Candy("Candy1", ingredients);
		assertEquals (0, candy1.score(likes, loves));
	}

	@Test
	void testScore5() {
		/*
		 * Purpose: testing when desired ingredients have all intersects with our 
		 * candy (some likes some loves)
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients gelatin, sugar, 
		 * lemons, cherry, chocolate
		 * Parameters: pass in the lists: likes = {"cherry", "chocolate", "sugar"}, 
		 * loves = {"gelatin","lemons"}
		 * Correct Result: 14
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons", "cherry", "chocolate"};
		Candy candy1 = new Candy("Candy1", ingredients);
		likes.add("chocolate");
		likes.add("sugar");
		likes.add("cherry");
		loves.add("gelatin");
		loves.add("lemons");
		assertEquals (14, candy1.score(likes, loves));
	}

	@Test
	void testScore6() {
		/*
		 * Purpose: testing when there are no likes and all intersects with loves)
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients gelatin, 
		 * sugar, lemons, cherry, chocolate
		 * Parameters: pass in the lists: likes = {"cherry", "chocolate", "sugar"}, 
		 * loves = {"gelatin","lemons"}
		 * Correct Result: 8
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons", "cherry", "chocolate"};
		Candy candy1 = new Candy("Candy1", ingredients);
		loves.add("gelatin");
		loves.add("lemons");
		assertEquals (8, candy1.score(likes, loves));
	}

	@Test
	void testScore7() {
		/*
		 * Purpose: testing when there are no loves and all intersects with likes)
		 * Method: method score
		 * Initialization: Construct Candy object with ingredients gelatin, sugar, 
		 * lemons, cherry, chocolate
		 * Parameters: pass in the lists: likes = {"cherry", "chocolate", "sugar"}, 
		 * loves = {"gelatin","lemons"}
		 * Correct Result: 4
		 */
		String[] ingredients = {"gelatin", "sugar", "lemons", "cherry", "chocolate"};
		Candy candy1 = new Candy("Candy1", ingredients);
		likes.add("sugar");
		likes.add("cherry");
		assertEquals (4, candy1.score(likes, loves));
	}
}
