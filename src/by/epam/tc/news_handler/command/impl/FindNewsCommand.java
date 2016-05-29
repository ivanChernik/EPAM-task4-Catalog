package by.epam.tc.news_handler.command.impl;

import by.epam.tc.news_handler.command.ICommand;
import by.epam.tc.news_handler.dao.INewsDAO;
import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.CommandException;
import by.epam.tc.news_handler.exception.ServiceException;
import by.epam.tc.news_handler.service.INewsService;
import by.epam.tc.news_handler.service.NewsServiceFactory;
import by.epam.tc.news_handler.service.impl.NewsServiceImpl;

public class FindNewsCommand implements ICommand{
	private static final String FAILURE = "Failure";
	private static final String SUCCESS = "success";
	private NewsServiceFactory newsServiceFactory = new NewsServiceFactory();
	private  INewsService newsService;
	
	public FindNewsCommand(){
		newsService = newsServiceFactory.getNewsService();
	}

	@Override
	public Response execute(Request request) throws CommandException {
		String newsName = request.getNewsName();
		String providerName = request.getProviderNewsName();
		Response response = new Response();
		
		try {
			News foundNews =  newsService.findNews(newsName, providerName);
			response.setStatus(true);
			response.setMessage(SUCCESS);
			response.setNews(foundNews);
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setErrorMessage(FAILURE);
			throw new CommandException(e);
		}
		
		return response;
	}

}
