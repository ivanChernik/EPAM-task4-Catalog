package by.epam.tc.news_handler.entity;


public class Request {
	private String commandName;
	private String newsName;
	private String providerNewsName;
	private String dateNews;
	private String bodyNews;
	private String categoryName;
	private String subcategoryName;

	public Request(){
		
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getProviderNewsName() {
		return providerNewsName;
	}

	public void setProviderNewsName(String providerNewsName) {
		this.providerNewsName = providerNewsName;
	}

	public String getDateNews() {
		return dateNews;
	}

	public void setDateNews(String dateNews) {
		this.dateNews = dateNews;
	}

	public String getBodyNews() {
		return bodyNews;
	}

	public void setBodyNews(String bodyNews) {
		this.bodyNews = bodyNews;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	
	
}
