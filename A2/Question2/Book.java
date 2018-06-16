import java.util.ArrayList;

public class Book implements IBookItem
{
	public String getAuthor()
	{
		return "Hemingway";
	}

	public String getTitle()
	{
		return "For Whom The Bell Tolls";
	}

	public boolean isDigitalOnly()
	{
		return false;
	}
}
