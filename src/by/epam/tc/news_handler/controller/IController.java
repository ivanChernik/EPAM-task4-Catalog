package by.epam.tc.news_handler.controller;

import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.ControllerException;

public interface IController {
	
	Response doAction(Request request) throws ControllerException;

}
