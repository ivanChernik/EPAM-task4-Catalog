package by.epam.tc.news_handler.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "news")
public class News {
	@XmlElement(name = "news-name")
	private String name;
	@XmlElement(name = "provider")
	private String provider;
	@XmlElement(name = "date-issue")
	private String date;
	@XmlElement(name = "news-body")
	private String body;

	public News() {

	}

	public News(String name, String provider, String date, String body) {
		this.name = name;
		this.provider = provider;
		this.date = date;
		this.body = body;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "News [name=" + name + ", provider=" + provider + ", date="
				+ date + ", body=" + body + "]";
	}
	

}
