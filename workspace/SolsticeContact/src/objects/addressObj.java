package objects;

public class addressObj{
	String street;
	String city;
	String state;
	String country;
	String zip;
	String latitude;
	String longitude;
	
	public addressObj(){
		
	}
	
	public addressObj(String street,String city,String state,String country,String zip,String latitude,String longitude){
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
		this.zip=zip;
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}