package com.urlshort.timyurl.UrlShortener.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class url_map_table implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String url_name;
	@Column(nullable = false, updatable = false, unique = true)
	private String uniq_string;

	public url_map_table() {}

	public url_map_table(Long id, String url_name, String uniq_string, String urlCode) {
		this.id = id;
		this.url_name = url_name;
		this.uniq_string = uniq_string;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl_name() {
		return url_name;
	}

	public void setUrl_name(String url_name) {
		this.url_name = url_name;
	}

	public String getUniq_string() {
		return uniq_string;
	}

	public void setUniq_string(String uniq_string) {
		this.uniq_string = uniq_string;
	}

	@Override
	public String toString() {
		return "url_map_table [id=" + id + ", url_name=" + url_name + ", uniq_string=" + uniq_string + "]";
	}

}
