package de.htwberlin.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mountains")
public class Mountain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "length")
	private long length;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "max_hight")
	private float maxHight;
	
	public Mountain() {}
	
	public Mountain(String name, String location, long length, String imageUrl, float maxHight) {
		super();
		this.name = name;
		this.location = location;
		this.length = length;
		this.imageUrl = imageUrl;
		this.maxHight = maxHight;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public float getMaxHight() {
		return maxHight;
	}
	public void setMaxHight(float maxHight) {
		this.maxHight = maxHight;
	}
	
	
}
