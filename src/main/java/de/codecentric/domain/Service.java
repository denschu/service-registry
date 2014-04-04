package de.codecentric.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String version;
	@Column(nullable = false)
	private String url;
	@Column
	private String message;
	@Column(nullable = false)
	private boolean active;

	public Service() {
	}

	public Service(String name, String version, String url, String message) {
		this.name = name;
		this.version = version;
		this.url = url;
		this.message = message;
		this.active = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format(
				"Service[id=%d, name='%s', version='%s', url='%s', message='%s', active='%s']", id, name,
				version, url, message, active);
	}

}
