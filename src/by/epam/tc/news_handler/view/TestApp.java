package by.epam.tc.news_handler.view;

import by.epam.tc.news_handler.controller.IController;
import by.epam.tc.news_handler.controller.impl.ControllerImpl;
import by.epam.tc.news_handler.entity.Response;
import by.epam.tc.news_handler.exception.ControllerException;


public class TestApp {
	public static final void main(String[] args) {
		View view = new View();
		IController controller =  new ControllerImpl();
		try {
			Response response = controller.doAction(view.doFindNews());
			view.printResponceFinding(response);
			controller.doAction(view.doSaveNews());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
