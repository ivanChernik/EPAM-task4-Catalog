package by.epam.tc.news_handler.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "categories")
public class Categories {
	@XmlElement(name = "category", type = Category.class)
	private List<Category> categoriesList = new ArrayList<Category>();
	public Categories(){
		
	}
	
	public void addCategory(Category inputCategory){
		categoriesList.add(inputCategory);
	}
	
	public List<Category> getCategoriesList() {
		return categoriesList;
	}
	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}


}
