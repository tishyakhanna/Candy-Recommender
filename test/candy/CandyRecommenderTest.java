/*
 * 7 September 2020
 * @author Tishya Khanna
 * This program is to perform JUnit tests for the class CandyRecommender
 */

package candy; 

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CandyRecommenderTest {
	
	@BeforeEach
	void initialize() {
		/*
		 * Initializing all objects before each test
		 */
		
		//list of candies
		CandyRecommender.candies = new ArrayList<>();
		
		//list of loves
		CandyRecommender.love = new ArrayList<>();
		
		//list of likes
		CandyRecommender.likes = new ArrayList<>();
		
		//list of dislikes
		CandyRecommender.dislikes = new ArrayList<>();
		
		//A map from ingredients to candies containing the ingredient.
		CandyRecommender.ingredientMap = new IngredientMap();
	} 
    
	@Test
	void testReadCandyFile() throws FileNotFoundException{
		/*
		 * Purpose: testing number of candies when the file is full and correct
		 * Method:readCandyFile
		 * Initialization: new CandyRecommender called tester
		 * Parameters: string filename which refers to a text file
		 * Correct Result: 18
		 */
		CandyRecommender.readCandyFile("Candy.txt");
        assertEquals(18, CandyRecommender.candies.size());
	}
	
	@Test
	void testReadCandyFile2() throws FileNotFoundException{
		/*
		 * Purpose: testing number of candies when the file is empty
		 * Method:readCandyFile
		 * Initialization: new CandyRecommender 
		 * Parameters: string filename which refers to an empty text file
		 * Correct Result: 0
		 */
		CandyRecommender.readCandyFile("empty.txt");
        assertEquals(0, CandyRecommender.candies.size());
	}
	
	
	@Test
	void testReadCandyFile3() throws FileNotFoundException{
		/*
		 * Purpose: testing when the file is empty
		 * Method:readCandyFile
		 * Initialization: new CandyRecommender
		 * Parameters: string filename which refers to an empty text file
		 * Correct Result: 0
		 */
		CandyRecommender.readCandyFile("empty.txt");
        assertEquals(0, CandyRecommender.ingredientMap.getMapSize());
	}
	
	@Test
	void testReadCandyFile4() throws FileNotFoundException{
		/*
		 * Purpose: testing number of ingredients when the file is full and correct
		 * Method:readCandyFile
		 * Initialization: new CandyRecommender
		 * Parameters: string filename which refers to a full and correct text file
		 * Correct Result: 11
		 */
		CandyRecommender.readCandyFile("Candy.txt");
        assertEquals(11, CandyRecommender.ingredientMap.getMapSize());
	}
	
	
	@Test 
	void testReadCandyFile5() throws FileNotFoundException{
		/*
		 * Purpose: testing number of candies when there is no such file
		 * Method:readCandyFile
		 * Initialization: new CandyRecommender 
		 * Parameters: string filename which refers to a false text file
		 * Correct Result: FileNotFoundException
		 */
        assertThrows(FileNotFoundException.class, () -> {
        	CandyRecommender.readCandyFile("oh_no.txt");
            });
	}
	
	
    @Test
    void testFindLovedCandies() throws FileNotFoundException{
		/*
		 * Purpose: testing that loved candies are 0 when likes, dislikes, love are empty
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Parameters: none
		 * Correct Result: 0
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(0, result.size());   	
    }
    
    @Test
    void testFindLovedCandies2() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes, love, dislikes
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {"LICORICE", "CARAMEL"}. likes = {"FRUIT", "CHOCOLATE"},
		 * dislikes = {"PEPPERMINT", "PEANUTS"}
		 * Parameters: none
		 * Correct Result: 3
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>(Arrays.asList("LICORICE", "CARAMEL"));
         CandyRecommender.likes=new ArrayList<>(Arrays.asList("FRUIT", "CHOCOLATE"));
         CandyRecommender.dislikes=new ArrayList<>(Arrays.asList("PEPPERMINT", "PEANUTS"));
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(3, result.size());   	
    }
    
    @Test
    void testFindLovedCandies2_1() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes, love, dislikes
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {"FRUIT", "CHOCOLATE"}. likes = {"LICORICE", "CARAMEL"}, 
		 * dislikes = {"PEPPERMINT", "PEANUTS"}
		 * Parameters: none
		 * Correct Result: 12
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>(Arrays.asList("FRUIT", "CHOCOLATE"));
         CandyRecommender.likes=new ArrayList<>(Arrays.asList("LICORICE", "CARAMEL"));
         CandyRecommender.dislikes=new ArrayList<>(Arrays.asList("PEPPERMINT", "PEANUTS"));
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(12, result.size());   	
    }
    
    @Test
    void testFindLovedCandies3() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes, love (empty), dislikes
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {}. likes = {"FRUIT", "CHOCOLATE"},
		 * dislikes = {"PEPPERMINT", "PEANUTS"}
		 * Parameters: none
		 * Correct Result: 0
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>();
         CandyRecommender.likes=new ArrayList<>(Arrays.asList("FRUIT", "CHOCOLATE"));
         CandyRecommender.dislikes=new ArrayList<>(Arrays.asList("PEPPERMINT", "PEANUTS"));
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(0, result.size());   	
    }
    
    @Test
    void testFindLovedCandies4() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes (empty), love, dislikes
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {"LICORICE", "CARAMEL"}. likes = {}, 
		 * dislikes = {"PEPPERMINT", "PEANUTS"}
		 * Parameters: none
		 * Correct Result: 3
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>(Arrays.asList("LICORICE", "CARAMEL"));
         CandyRecommender.likes=new ArrayList<>();
         CandyRecommender.dislikes=new ArrayList<>(Arrays.asList("PEPPERMINT", "PEANUTS"));
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(3, result.size());   	
    }
    
    @Test
    void testFindLovedCandies5() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes, love, dislikes (empty)
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {"LICORICE", "CARAMEL"}. likes = {"FRUIT", "CHOCOLATE"}, 
		 * dislikes = {}
		 * Parameters: none
		 * Correct Result: 4
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>(Arrays.asList("LICORICE", "CARAMEL"));
         CandyRecommender.likes=new ArrayList<>(Arrays.asList("FRUIT", "CHOCOLATE"));
         CandyRecommender.dislikes=new ArrayList<>();
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(4, result.size());   	
    }
    
    @Test
    void testFindLovedCandies6() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes (empty), love, dislikes (empty)
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {"LICORICE", "CARAMEL"}. likes = {}, dislikes = {}
		 * Parameters: none
		 * Correct Result: 4
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>(Arrays.asList("LICORICE", "CARAMEL"));
         CandyRecommender.likes=new ArrayList<>();
         CandyRecommender.dislikes=new ArrayList<>();
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(4, result.size());   	
    }
    
    @Test
    void testFindLovedCandies7() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes, love (empty), dislikes (empty)
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {}. likes = {"FRUIT", "CHOCOLATE"}, dislikes = {}
		 * Parameters: none
		 * Correct Result: 0
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>();
         CandyRecommender.likes=new ArrayList<>(Arrays.asList("FRUIT", "CHOCOLATE"));
         CandyRecommender.dislikes=new ArrayList<>();
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(0, result.size());   	
    }
    
    @Test
    void testFindLovedCandies8() throws FileNotFoundException{
		/*
		 * Purpose: testing loved candies for given likes (empty), love (empty), dislikes
		 * Method: testFindLikedCandies
		 * Initialization: new CandyRecommender with Candy.txt 
		 * Initialization: love = {}. likes = {}, dislikes = {"PEPPERMINT", "PEANUTS"}
		 * Parameters: none
		 * Correct Result: 0
		 */
		 CandyRecommender.readCandyFile("Candy.txt");
         CandyRecommender.love=new ArrayList<>();
         CandyRecommender.likes=new ArrayList<>();
         CandyRecommender.dislikes=new ArrayList<>(Arrays.asList("PEPPERMINT", "PEANUTS"));
    	 Set<Candy> result = CandyRecommender.findLovedCandies();
         assertEquals(0, result.size());   	
    }
    	
}

