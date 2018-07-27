public class Address
{
    private String street;
    private String city;
    private String province;
    private String postalcode;

    public Address(String street, String city, String province, String postalcode)
    {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public String getProvince()
    {
        return province;
    }

    public String getPostalcode()
    {
        return postalcode;
    }

    public boolean isEqualTo(Address address)
    {
        return this.getStreet().equals(address.getStreet()) &&
            this.getCity().equals(address.getCity()) &&
            this.getProvince().equals(address.getProvince()) &&
            this.getPostalcode().equals(address.getPostalcode());
    }
}
