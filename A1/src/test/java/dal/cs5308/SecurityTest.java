package dal.cs5308;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SecurityTest {

    private ISecurity security;

    @Before
    public void beforeAll() {
        security = new MockSecurity();
    }

    @Test
    public void fakeIdAndFakeKeyTest() {
        assertFalse(security.isDealerAuthorized("FAKEID", "FAKEKEY"));
    }

    @Test
    public void fakeIdTest() {
        assertFalse(security.isDealerAuthorized("FAKEID", "lksajlkfjslkdjf"));
    }

    @Test
    public void fakeKeyTest() {
        assertFalse(security.isDealerAuthorized("lskjdlfkjskdjf", "FAKEKEY"));
    }

    @Test
    public void authorizedDealerTest() {
        assertTrue(security.isDealerAuthorized("lskjdflkjsd", "lskjdfkjsdf"));
    }

    @After
    public void afterAll() {
        security = null;
    }
}
