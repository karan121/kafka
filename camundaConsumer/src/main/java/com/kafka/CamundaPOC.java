package com.kafka;

public class CamundaPOC {

	private String client;
	
	private String technology;
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "CamundaPOC [client=" + client + ", technology=" + technology + "]";
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	
}
