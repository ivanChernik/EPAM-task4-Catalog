package by.epam.tc.news_handler.command;

import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.CommandException;

public interface ICommand {
	
	Response execute(Request request) throws CommandException;

}
