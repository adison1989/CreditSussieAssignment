package com.assignment.creditSussie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


@Entity
@Component
public class LogDetails {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(unique=true, nullable=false, name="id")
	private String logId;
	private String state;
	private String type;
	private String host;
	private String timestamp;
	private boolean alert;
	
	public LogDetails() {
		
	}

	public LogDetails(String logId, String state, String type, String host, String timestamp) {
		super();
		this.logId = logId;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "LogDetails [id=" + logId + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp="
				+ timestamp + ", alert=" + alert + "]";
	}

}
