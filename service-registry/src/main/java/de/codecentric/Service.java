package de.codecentric;

public class Service {

	public Service(String name, String version, String url) {
		this.name = name;
		this.version = version;
		this.url = url;
	}

	private String name;
	private String version;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
