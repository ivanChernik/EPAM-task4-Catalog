package by.epam.tc.news_handler.command.impl;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import by.epam.tc.news_handler.command.ICommand;
import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.CommandException;
import by.epam.tc.news_handler.exception.ServiceException;
import by.epam.tc.news_handler.service.INewsService;
import by.epam.tc.news_handler.service.NewsServiceFactory;

public class FindNewsCommand implements ICommand {
	private static final String SERVICE_EXCEPTION_NOT_VALIDED_ARGUMENTS = "ServiceException, not valided arguments, operation - find";
	private static final Logger log = Logger.getLogger(FindNewsCommand.class);
	private static final String FAILURE = "Failure";
	private static final String SUCCESS = "success";
	private NewsServiceFactory newsServiceFactory = new NewsServiceFactory();
	private INewsService newsService;

	public FindNewsCommand() {
		newsService = newsServiceFactory.getNewsService();
	}

	@Override
	public Response execute(Request request) throws CommandException {
		String newsName = request.getNewsName();
		String providerName = request.getProviderNewsName();
		Response response = new Response();

		try {
			News foundNews = newsService.findNews(newsName, providerName);
			response.setStatus(true);
			response.setMessage(SUCCESS);
			response.setNews(foundNews);
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setErrorMessage(FAILURE);
			if (log.isEnabledFor(Priority.ERROR)) {
				log.error(SERVICE_EXCEPTION_NOT_VALIDED_ARGUMENTS, e);
			}
			throw new CommandException(e);
		}

		return response;
	}

}
