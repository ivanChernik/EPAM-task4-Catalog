package by.epam.tc.news_handler.controller.impl;

import by.epam.tc.news_handler.command.CommandHelper;
import by.epam.tc.news_handler.command.ICommand;
import by.epam.tc.news_handler.controller.IController;
import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.CommandException;
import by.epam.tc.news_handler.exception.ControllerException;

public class ControllerImpl implements IController {
	private CommandHelper helper = new CommandHelper();
	
	public Response doAction(Request request) throws ControllerException{
		String commandName = request.getCommandName();
		ICommand command = helper.getCommandName(commandName);
		Response response = null;
		try {
			response = command.execute(request);
		} catch (CommandException e) {
			throw new ControllerException(e);
		}
		return response;
	}
	

}
