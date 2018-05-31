package dal.cs5308;

public class MockDatabase implements IDatabase {

    /*
    Returns false if partNumber is negative, returns true otherwise.
     */
    @Override
    public boolean isPartNumberValid(int partNumber) {
        return partNumber >= 0;
    }
}
