package fcu.opendata.jenabean;

import java.util.Date;

import thewebsemantic.Id;
import thewebsemantic.Namespace;
import thewebsemantic.binding.RdfBean;

@Namespace("http://cloud.culture.tw/resources/")
public class EventInstance extends RdfBean<EventInstance> {

	@Id
	private String id;
	private Date time;
	private String address;
	private String location;
	private boolean isAvailable;
	private String price;
	private float latitude;
	private float longitude;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
