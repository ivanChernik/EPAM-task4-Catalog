package by.epam.tc.news_handler.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.tc.news_handler.command.impl.FindNewsCommand;
import by.epam.tc.news_handler.command.impl.SaveNewNewsCommand;

public class CommandHelper {
	private Map <CommandName, ICommand> commands = new HashMap<>();
	
	public CommandHelper(){
		commands.put(CommandName.SAVE_NEW_NEWS, new SaveNewNewsCommand());
		commands.put(CommandName.FIND_NEWS, new FindNewsCommand());
		
	}
	
	public ICommand getCommandName(String commandName){
		CommandName commandKeyName = CommandName.valueOf(commandName);
		ICommand command = commands.get(commandKeyName);
		return command;
	}

}
