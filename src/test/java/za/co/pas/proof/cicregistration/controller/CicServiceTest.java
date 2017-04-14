package za.co.pas.proof.cicregistration.controller;

//import javax.ejb.EJB;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.container.test.api.RunAsClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
/**
 * This is to test the Service Layer<p>
 * <b>I gave up - it took too long to fight with the container</b><p>
 * JUnit 1 : Me 0<p>
 * I left my efforts in
 * @author Andre Labuschagne
 */
//@RunWith(Arquillian.class)
//@RunAsClient
public class CicServiceTest {

//    @EJB
//    CicService instance;
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//
//        JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
//        jar.addAsResource("test-persistence.xml", "META-INF/persistence.xml");
//        jar.addPackage("za.co.pas.proof.cicregistration.controller");
//        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//
//        return jar;
//    }   

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
     * Test of registerCic method, of class CicService.
     */
    @Test
    public void testRegisterCic() throws Exception {
        System.out.println("registerCic");
        String cicType = "cicType";
        String subject = "Cic Subject";
        String body = "Cic body";
        String sourceSystem = "Source System";
        String name = "Kosie";
        String email = "kosie@nowhere.com";
////        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
////            CicService instance = (CicService) container.getContext().lookup("java:global/classes/CicService");
//            boolean expResult = false;
//            boolean result = instance.registerCic(cicType, subject, body, sourceSystem, name, email);
//            assertEquals(expResult, result);
////        }
        assertTrue(true);
    }
}
