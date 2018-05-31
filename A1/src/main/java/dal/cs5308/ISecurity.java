package dal.cs5308;

public interface ISecurity {
    // Returns whether the dealer is authorized to order parts on behalf of their customers.
    boolean isDealerAuthorized(String dealerId, String dealerAccessKey);
}