package by.epam.tc.news_handler.dao;

import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.exception.DAOException;

public interface INewsDAO {
	void saveNews(News inputNews, String categoryName, String subcategoryName) throws DAOException;

	News findNews(String newsName, String providerName) throws DAOException;

}
