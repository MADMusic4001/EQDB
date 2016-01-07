/**
 * 
 */
package com.madmusic4001.eqdb.beans;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.madmusic4001.eqdb.interfaces.ItemService;
import com.madmusic4001.eqdb.model.EQClass;
import com.madmusic4001.eqdb.model.Race;
import com.madmusic4001.eqdb.model.Size;

/**
 * Tests the ItemServiceBean class
 */
public class ItemServiceBeanTest {
	private static EJBContainer container;
	private static Context context;

	@BeforeClass
	public static void initContainer() throws Exception {
		Map<String, File[]> properties = new HashMap<String, File[]>();
		properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
	    container = EJBContainer.createEJBContainer(properties);
	    context = container.getContext();
	}

	@AfterClass
	public void closeContainer() throws Exception {
		if(container != null ) {
			container.close();
		}
	}

	@Test
	public void shouldFindAllItems() throws Exception {
		// Check JNDI dependencies
        assertNotNull(context.lookup("java:global/classes/ItemServiceBean"));
//        assertNotNull(context.lookup("java:global/jdbc/EQDBDatabase"));

        // Looks up for the EJB
        ItemService bean = (ItemService)context.lookup("java:global/classes/ItemServiceBean");

        bean.createItem(null, "Test", new BigDecimal("1.5"), Size.GIANT, false, false, false, false, false,
        		Race.ALL_RACES, EQClass.ALL_CLASSES);
	}
}

