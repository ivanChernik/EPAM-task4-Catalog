package by.epam.tc.news_handler.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "category")
public class Category {
	@XmlElement(name = "subcategory", type = Subcategory.class)
	private List<Subcategory> subcategoryList = new ArrayList<Subcategory>();
	
	@XmlElement(name = "category-name")
	private String name;
	
	public Category(){
		
	}
	
	public void addSubcategory(Subcategory inputSubcategory){
		subcategoryList.add(inputSubcategory);
	}

	public List<Subcategory> getSubcategoryList() {
		return subcategoryList;
	}

	public void setSubcategoryList(List<Subcategory> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
