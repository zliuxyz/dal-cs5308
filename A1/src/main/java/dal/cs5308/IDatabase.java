package dal.cs5308;

public interface IDatabase {

    // Returns true if the partNumber is valid, false otherwise.
    boolean isPartNumberValid(int partNumber);
}
