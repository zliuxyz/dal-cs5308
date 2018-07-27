public class Person
{
    public String name;
    public Address address;

    public Person()
    {
        name = "Rob";
        address = new Address("Rob street", "Rob city", "Rob province", "Rob postalcode");
    }

    public boolean IsPersonRob()
    {
        Address robsAddress = new Address("Rob street", "Rob city", "Rob province", "Rob postalcode");
        return name.equals("Rob") && IsRobsAddress(robsAddress);
    }

    private boolean IsRobsAddress(Address robsAddress)
    {
        return address.isEqualTo(robsAddress);
    }
}
