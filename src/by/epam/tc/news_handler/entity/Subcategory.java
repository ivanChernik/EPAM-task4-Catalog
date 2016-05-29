package by.epam.tc.news_handler.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "subcategory")
public class Subcategory {
	//@XmlElementWrapper
	@XmlElement(name = "news", type = News.class)
	private List<News> newsList = new ArrayList<News>();
	@XmlElement(name = "subcategory-name")
	private String name;

	public Subcategory() {

	}
	
	public void addNews(News inputNews){
		newsList.add(inputNews);
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
