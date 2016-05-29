package by.epam.tc.news_handler.view;

import by.epam.tc.news_handler.entity.News;
import by.epam.tc.news_handler.entity.Request;
import by.epam.tc.news_handler.entity.Response;

public class View {

	public Request doFindNews() {
		Request request = new Request();
		request.setCommandName("FIND_NEWS");
		request.setProviderNewsName("������ ����");
		request.setNewsName("����� ����� ���� �������� ����� ����������");
		return request;
	}
	
	public Request doSaveNews(){
		News sendingNews = new News("45454","ivan", "20-25-2015", "news ...");
		Request request = new Request();
		request.setCommandName("SAVE_NEW_NEWS");
		request.setProviderNewsName("�������� ����");
		request.setNewsName("����� ����� ���� ���� ����� ����������");
		request.setBodyNews("������� � 3 ����");
		request.setCategoryName("�����");
		request.setSubcategoryName("�����");
		request.setDateNews("20-12-2003");
		return request;
	}

	public void printResponceFinding(Response response) {
		News resultNews = response.getNews();
		System.out.println(resultNews.getName());
		System.out.println(resultNews.getProvider());
		System.out.println(resultNews.getDate());
		System.out.println(resultNews.getBody());

	}
	
}
