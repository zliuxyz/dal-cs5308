public class Credential
{
    private String userName;
    private String password;

    public Credential()
    {
        this.userName = "";
        this.password = "";
    }

    public Credential(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public void setLoginCredentials(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public boolean authenticateUser()
    {
        return (userName.equals("joe") && password.equals("joepass"));
    }
}
