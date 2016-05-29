package by.epam.tc.news_handler.service;

import by.epam.tc.news_handler.service.impl.NewsServiceImpl;

public class NewsServiceFactory {
	private static INewsService newsService = new NewsServiceImpl();
	
	public static INewsService getNewsService(){
		return newsService;
	}

}
