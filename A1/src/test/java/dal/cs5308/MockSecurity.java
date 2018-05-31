package dal.cs5308;

public class MockSecurity implements ISecurity {

    // Only returns false dealerId equals to "FAKEID" and dealerAccessKey equals to "FAKEKEY", returns
    // true otherwise.
    @Override
    public boolean isDealerAuthorized(String dealerId, String dealerAccessKey) {
        return !dealerId.equals("FAKEID") && !dealerAccessKey.equals("FAKEKEY");
    }
}
