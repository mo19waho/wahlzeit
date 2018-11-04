import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.handlers.TellFriendTest.class,
    EmailServiceTestSuite.class,
    org.wahlzeit.services.LogBuilderTest.class,
	ModelTestSuite.class,
    UtilsTestSuite.class
})
public class AllTests
{
   /** do nothing**/
}
