import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;

public class Help
{
    Map<String, Command> map;

    public Help()
    {
        map = new LinkedHashMap<>();
        map.put("print", new PrintCommand());
        map.put("open", new OpenCommand());
        map.put("close", new CloseCommand());
    }

    public String GetHelp(String command)
    {
        if (command != null && command.length() != 0)
        {
            return map.get(command).getHelp();
        }
        return ListAllCommands();
    }

    public String ListAllCommands()
    {
        StringBuilder allCommands = new StringBuilder("Commands: ");
        Set<String> keySet = map.keySet();
        String[] commandsArray = keySet.toArray(new String[0]);
        for (int i = 0; i < commandsArray.length; i++)
        {
            allCommands.append(commandsArray[i]);
            if (i < commandsArray.length - 1)
            {
                allCommands.append(", ");
            }
        }
        return allCommands.toString();
    }
}
