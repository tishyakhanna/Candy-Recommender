/*
 * 7 September 2020
 * @author Tishya Khanna
 * This program is to perform JUnit tests for the class IngredientMap
 */

package candy; 


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Testing class IngredientMap
 */
class IngredientMapTest {
	//A map from ingredients to candies containing the ingredient.
	private IngredientMap ingredientMap; 

	//sample candies to perform tests on
	private Candy candy1;
	private Candy candy2;
	private Candy candy3;

	//empty newList to add candies for comparison
	Collection<Candy> newList;

	@BeforeEach
	void initialize() {
		/*
		 * Initializing all objects before each test
		 */
		candy1 = new Candy("Candy1", new String[] {"gelatin", "sugar", "lemons", "cherry", "chocolate"});
		candy2 = new Candy("Candy2", new String[] {"gelatin", "sugar", "lemons"});
		candy3 = new Candy("Candy3", new String[] {"gelatin"});
		ingredientMap = new IngredientMap();
		newList = new ArrayList<>();
	} 


	@Test
	void testAdd() {
		/*
		 * Purpose: testing whether multiple candies can be added 
		 * for 1 ingredient 
		 * Method:add
		 * Initialization: new ingredientmap, candy1 and candy2
		 * Parameters: "cars" and the candies to which it needs to be 
		 * added (candy1 & candy2  here)
		 * Correct Result: cars (when getCandyWith is called)
		 */
		ingredientMap.add("cars", candy1);
		ingredientMap.add("cars", candy2);
		newList.add(candy1);
		newList.add(candy2);
		assertEquals(newList,ingredientMap.getCandyWith("cars"));
	}


	@Test
	void testAdd2() {
		/*
		 * Purpose: tests if an ingredient can be added twice
		 * Method:add
		 * Initialization: new ingredientmap and candy1 
		 * Parameters: "cars" and the candy to which it needs to be 
		 * added (candy1 here)
		 * Correct Result: yes it gets added
		 */
		ingredientMap.add("cars", candy1);
		ingredientMap.add("cars", candy1);
		newList.add(candy1);
		newList.add(candy1);
		assertEquals(newList,ingredientMap.getCandyWith("cars"));
	}

	@Test
	void testAdd3() {
		/*
		 * Purpose: tests if a new ingredient can be added once
		 * Method:add
		 * Initialization: new ingredientmap and candy1 
		 * Parameters: "gelatin" and the candy to which it needs to be 
		 * added (candy1 here)
		 * Correct Result: yes it gets added
		 */
		ingredientMap.add("gelatin", candy1);
		newList.add(candy1);
		assertEquals(newList,ingredientMap.getCandyWith("gelatin"));
	}

	@Test
	void testgetCandyWith() {
		/*
		 * Purpose: tests if you can retrieve all the candies of an ingredient 
		 * & if they get added correctly
		 * Method: getCandyWith and add
		 * Initialization: new ingredientmap, candy1, candy2, candy3 
		 * Parameters: "cars" and the candies to which it needs to be retrieve  
		 * Correct Result: a collection that contains candy1, candy2, candy3
		 */
		ingredientMap.add("cars", candy1);
		ingredientMap.add("cars", candy2);
		ingredientMap.add("cars", candy3);
		newList.add(candy1);
		newList.add(candy2);
		newList.add(candy3);
		assertEquals(newList,ingredientMap.getCandyWith("cars"));	
	}

}
