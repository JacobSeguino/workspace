package objects;

public class detailObj{
	int employeeId;
	boolean favorite;
	String largeImageURL;
	String email;
	String website;
	addressObj address;
	
	public detailObj(){
		
	}
	
	public detailObj(int employeeId,boolean favorite,String largeImageURL,String email,String website,addressObj address){
		this.employeeId=employeeId;
		this.favorite=favorite;
		this.largeImageURL=largeImageURL;
		this.email=email;
		this.website=website;
		this.address=address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getLargeImageURL() {
		return largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public addressObj getAddress() {
		return address;
	}

	public void setAddress(addressObj address) {
		this.address = address;
	}
	
	
}