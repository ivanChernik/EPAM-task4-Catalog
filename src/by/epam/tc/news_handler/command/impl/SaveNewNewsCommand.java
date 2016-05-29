package by.epam.tc.news_handler.command.impl;

import by.epam.tc.news_handler.command.ICommand;
import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.CommandException;
import by.epam.tc.news_handler.exception.ServiceException;
import by.epam.tc.news_handler.service.INewsService;
import by.epam.tc.news_handler.service.NewsServiceFactory;

public class SaveNewNewsCommand implements ICommand {

	private static final String FAILURE = "Failure";
	private static final String SUCCESS = "success";
	private NewsServiceFactory newsServiceFactory = new NewsServiceFactory();
	private INewsService newsService;

	public SaveNewNewsCommand() {
		newsService = newsServiceFactory.getNewsService();
	}

	@Override
	public Response execute(Request request) throws CommandException {
		String newsName = request.getNewsName();
		String providerNewsName = request.getProviderNewsName();
		String dateNews = request.getDateNews();
		String bodyNews = request.getBodyNews();
		String categoryName = request.getCategoryName();
		String subcategoryName = request.getSubcategoryName();
		Response response = new Response();

		try {
			newsService.saveNewNews(newsName, providerNewsName, dateNews,
					bodyNews, categoryName, subcategoryName);
			response.setStatus(true);
			response.setMessage(SUCCESS);
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setErrorMessage(FAILURE);
			throw new CommandException(e);
		}

		return response;
	}

}
