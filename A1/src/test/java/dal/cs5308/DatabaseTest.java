package dal.cs5308;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    private IDatabase database;

    @Before
    public void testSetup() {
        database = new MockDatabase();
    }

    @Test
    public void validPartNumberTest() {
        assertTrue(database.isPartNumberValid(10));
    }

    @Test
    public void invalidPartNumberTest() {
        assertFalse(database.isPartNumberValid(-10));
    }

    @After
    public void testTeardown() {
        database = null;
    }
}
