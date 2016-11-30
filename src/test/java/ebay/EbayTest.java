/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebay;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class EbayTest {
    
    public EbayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sendGet method, of class Ebay.
     */
    @Test
    public void testSendGet() throws Exception {
        System.out.println("sendGet");
        Ebay instance = new Ebay();
        String result = instance.findByKeywords("xbox");
        assertTrue(!result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
