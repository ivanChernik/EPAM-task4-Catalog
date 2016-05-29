package by.epam.tc.news_handler.dao;

import by.epam.tc.news_handler.dao.impl.NewsDAOImpl;

public class NewsDAOFactory {
	private static INewsDAO newsDAO = new NewsDAOImpl();

	public static INewsDAO getNewsDAO() {
		return newsDAO;
	}
}
