
package com.nagarro.nagp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.nagarro.nagp.domain.Category;
import com.nagarro.nagp.exception.InvalidRequestException;
import com.nagarro.nagp.repository.DurableInventoryRepository;
import com.nagarro.nagp.repository.FragileInventoryRepository;
import com.nagarro.nagp.repository.RepositoryHelper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;


/**
 * The Class InventoryResourceTest.
 */
public class InventoryResourceTest {

	/** The inventory resource. */
	@InjectMocks
	InventoryResource inventoryResource;
	
	/** The durable inventory repository. */
	@Mock
	DurableInventoryRepository durableInventoryRepository;
	
	/** The fragile inventory repository. */
	@Mock
	FragileInventoryRepository fragileInventoryRepository;
	
	/** The repository helper. */
	@Mock
	RepositoryHelper repositoryHelper;
	
	/** The expected ex. */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	/**
     * Default constructor.
     *
     */
    public InventoryResourceTest() {
        super();
    }
    
    /**
     * Setup.
     */
    @Before
    public void setup() {
    	inventoryResource = new InventoryResource();
    	durableInventoryRepository = mock(DurableInventoryRepository.class);
    	fragileInventoryRepository = mock(FragileInventoryRepository.class);
    	Mockito.doNothing().when(durableInventoryRepository).save(Mockito.any(Inventory.class));
    	Mockito.doNothing().when(fragileInventoryRepository).save(Mockito.any(Inventory.class));
    	
    }
    
    /**
     * Save fragile.
     */
    @Test
    public void saveFragile()  {
    	Category category = Category.FRAGILE;
    	Inventory inventory = new Inventory(category);
    	assertNotNull(inventoryResource.createInventory(inventory));
    }

    /**
     * Save durable.
     */
    @Test
    public void saveDurable()  {
    	Category category = Category.DURABLE;
    	Inventory inventory = new Inventory(category);
    	assertNotNull(inventoryResource.createInventory(inventory));
    }
    
    /**
     * Should throw invalid request exception when inventoryis null.
     */
    @Test()
    public void shouldThrowInvalidRequestExceptionWhenInventoryisNull()  {
    	expectedEx.expect(InvalidRequestException.class);
        expectedEx.expectMessage("Inventory must not be null");
        inventoryResource.createInventory(null);
    }
    
    /**
     * Checks if is throw exception when invalid inventory.
     */
    @Test()
    public void isThrowExceptionWhenInvalidInventory()  {
    	Category category = null;
    	Inventory inventory = new Inventory(category);
    	expectedEx.expect(InvalidRequestException.class);
        expectedEx.expectMessage("Wrong inventory type");
        inventoryResource.createInventory(inventory);
    }
    
    
}
