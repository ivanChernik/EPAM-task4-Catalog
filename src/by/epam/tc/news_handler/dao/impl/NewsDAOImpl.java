package by.epam.tc.news_handler.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import by.epam.tc.news_handler.dao.INewsDAO;
import by.epam.tc.news_handler.entity.Categories;
import by.epam.tc.news_handler.entity.Category;
import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.entity.Subcategory;
import by.epam.tc.news_handler.exception.DAOException;

public class NewsDAOImpl implements INewsDAO {
	private List<News> allNewsList = new ArrayList<News>();
	private Categories categories;
	private static final String PATH = "src/by/epam/tc/news_handler/xml/NewsFile.xml";

	@Override
	public void saveNews(News inputNews, String categoryName,
			String subcategoryName) throws DAOException {
		marshallFile(inputNews, categoryName, subcategoryName);
	}

	@Override
	public News findNews(String newsName, String providerName)
			throws DAOException {
		unmarshallFile();
		News foundNews = findNewsbyRequirements(newsName, providerName);
		return foundNews;
	}

	private void marshallFile(News inputNews, String categoryName,
			String subcategoryName) {
		unmarshallFile();
		if (!checkSimilarData(inputNews, categoryName, subcategoryName)) {
			Category category = new Category();
			category.setName(categoryName);
			Subcategory subcategory = new Subcategory();
			subcategory.setName(subcategoryName);
			subcategory.addNews(inputNews);
			category.addSubcategory(subcategory);
			categories.addCategory(category);

			Marshaller jaxbMarshaller = null;
			try {
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Categories.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(categories, new File(PATH));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void unmarshallFile() {
		categories = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// jaxbUnmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// true);
			categories = (Categories) jaxbUnmarshaller
					.unmarshal(new File(PATH));
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		for (Category iterableCategory : categories.getCategoriesList()) {

			for (Subcategory iterableSubcategory : iterableCategory
					.getSubcategoryList()) {

				allNewsList.addAll(iterableSubcategory.getNewsList());

			}
		}

	}

	private News findNewsbyRequirements(String newsName, String providerName) {
		News foundNews = null;
		for (News iterableNews : allNewsList) {
			if (iterableNews.getName().equals(newsName)
					&& iterableNews.getProvider().equals(providerName)) {
				foundNews = iterableNews;
				break;
			}
		}
		return foundNews;

	}

	private boolean checkSimilarData(News inputNews, String categoryName,
			String subcategoryName) {
		unmarshallFile();
		for (Category iterableCategory : categories.getCategoriesList()) {
			if (iterableCategory.getName().equals(categoryName))
				return true;
			for (Subcategory iterableSubcategory : iterableCategory
					.getSubcategoryList()) {
				if (iterableSubcategory.getName().equals(subcategoryName))
					return true;
				for (News iterableNews : iterableSubcategory.getNewsList()) {
					if (inputNews.equals(iterableNews))
						return true;
				}

			}
		}
		return false;
	}
}
