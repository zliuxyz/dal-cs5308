public class PhoneNumber
{
    private String areaCode;
    private String number;

    public PhoneNumber()
    {
        this.areaCode = "";
        this.number = "";
    }

    public PhoneNumber(String areaCode, String number)
    {
        this.areaCode = areaCode;
        this.number = number;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public String getPhoneNumber()
    {
        if (areaCode != null && areaCode != "")
        {
            return "(" + areaCode + ") " + number;
        }
        return number;
    }
}
