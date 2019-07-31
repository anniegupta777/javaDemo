/**
 * 
 */
package com.nagarro.nagp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nagarro.nagp.domain.Category;

import static org.junit.Assert.assertEquals;

/**
 * The Class InventoryTest.
 */
public class InventoryTest {

	
	/** The inventory. */
	@InjectMocks
    private Inventory inventory;
	
	/** The category. */
	@Mock
    private Category category;
	
	/**
     * Default constructor.
     *
     */
    public InventoryTest() {
        super();
    }
    
    /**
     * Setup.
     */
    @Before
    public void setup() {
    	category = Category.valueOf("DURABLE");
    	
        
    }
    
    /**
     * Checks if is durable.
     */
    @Test
    public void isDurable()  {
    	Inventory inventory = new Inventory(category);
        assertEquals(Category.valueOf("DURABLE"),inventory.getCategory());
    }

    /**
     * Checks if is fragile.
     */
    @Test
    public void isFragile()  {
    	category = Category.valueOf("FRAGILE");
    	Inventory inventory = new Inventory(category);
        assertEquals(Category.valueOf("FRAGILE"),inventory.getCategory());
    }

}
