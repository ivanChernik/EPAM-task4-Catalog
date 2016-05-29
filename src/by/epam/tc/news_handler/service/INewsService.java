package by.epam.tc.news_handler.service;

import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.exception.ServiceException;

public interface INewsService {
	void saveNewNews( String newsName,
			String providerNewsName, String dateNews, String bodyNews,
			String categoryName, String subcategoryName)
			throws ServiceException;

	News findNews(String newsName, String providerName) throws ServiceException;

}
