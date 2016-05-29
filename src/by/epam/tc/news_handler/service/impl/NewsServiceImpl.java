package by.epam.tc.news_handler.service.impl;

import by.epam.tc.news_handler.dao.INewsDAO;
import by.epam.tc.news_handler.dao.NewsDAOFactory;
import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.exception.DAOException;
import by.epam.tc.news_handler.exception.ServiceException;
import by.epam.tc.news_handler.service.INewsService;

public class NewsServiceImpl implements INewsService {
	private static final String NOT_INITIALIZATION_FOR_SAVING = "not initialization for saving";
	private static final String NOT_INITIALIZATION_FOR_FINDING = "not initialization for finding";
	private NewsDAOFactory newsDAOFactory = new NewsDAOFactory();
	private INewsDAO newsDAO;

	public NewsServiceImpl() {
		newsDAO = newsDAOFactory.getNewsDAO();
	}

	@Override
	public void saveNewNews( String newsName,
			String providerNewsName, String dateNews, String bodyNews,
			String categoryName, String subcategoryName)
			throws ServiceException {

		if ( newsName == null || providerNewsName == null
				|| dateNews == null || bodyNews == null || categoryName == null
				|| subcategoryName == null) {
			throw new ServiceException(NOT_INITIALIZATION_FOR_SAVING,
					new Exception());
		}
		
		
		News sendingNews = new News(newsName,providerNewsName, dateNews, bodyNews);
		try {
			newsDAO.saveNews(sendingNews, categoryName, subcategoryName);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		

	}

	@Override
	public News findNews(String newsName, String providerName)
			throws ServiceException {
		if (newsName == null || providerName == null) {
			throw new ServiceException(NOT_INITIALIZATION_FOR_FINDING,
					new Exception());
		}

		News foundNews = null;
		try {

			foundNews = newsDAO.findNews(newsName, providerName);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return foundNews;
	}

}
