public class Person
{
    private String name;

    private PhoneNumber phoneNumber = new PhoneNumber();

    private Credential credential = new Credential();
    
    public Person(String name)
    {
        this.name = name;
    }

    public void SetAreaCode(String areaCode)
    {
        phoneNumber.setAreaCode(areaCode);
    }
    public String GetAreaCode()
    {
        return phoneNumber.getAreaCode();
    }
    public void SetPhoneNumber(String number)
    {
        phoneNumber.setNumber(number);
    }
    public String GetPhoneNumber()
    {
        return phoneNumber.getPhoneNumber();
    }

    public void SetLoginCredentials(String userName, String password)
    {
        credential.setLoginCredentials(userName, password);
    }
    public boolean AuthenticateUser()
    {
        return credential.authenticateUser();
    }
}
