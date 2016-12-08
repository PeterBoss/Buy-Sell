/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebay;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import test.utils.EmbeddedTomcat;

/**
 *
 * @author Peter
 */
public class EbayTest {

    private static final int SERVER_PORT = 9999;
    private static final String APP_CONTEXT = "/seed";
    private static EmbeddedTomcat tomcat;

    public EbayTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ServletException, MalformedURLException, LifecycleException {
        tomcat = new EmbeddedTomcat();
        tomcat.start(SERVER_PORT, APP_CONTEXT);
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = SERVER_PORT;
        RestAssured.basePath = APP_CONTEXT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
        tomcat.stop();
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
    public void testGet() throws Exception {
        Ebay instance = new Ebay();
        String result = instance.findByKeywords("xbox");
        assertTrue(!result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGet2() {
        given()
                .contentType("application/json")
                .when()
                .get("/api/ebaysearch/test").then()
                .statusCode(200);
    }

}
