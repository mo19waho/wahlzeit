import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    /* org.wahlzeit.model.persistence.AbstractAdapterTest.class, was not run with former wildcard test, FAILS when run here */ 
    org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
    org.wahlzeit.model.AccessRightsTest.class,
    org.wahlzeit.model.FlagReasonTest.class,
    org.wahlzeit.model.GenderTest.class,
    org.wahlzeit.model.GuestTest.class,
    org.wahlzeit.model.LocationTest.class,
    org.wahlzeit.model.SailingVesselPhotoTest.class,
    org.wahlzeit.model.PhotoFilterTest.class,
    org.wahlzeit.model.TagsTest.class,
    org.wahlzeit.model.UserStatusTest.class,
    org.wahlzeit.model.ValueTest.class
})
public class ModelTestSuite
{
   /** do nothing **/
}