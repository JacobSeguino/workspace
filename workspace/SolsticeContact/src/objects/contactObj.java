package objects;

public class contactObj{
	String name;
	int employeeId;
	String company;
	String detailsURL;
	String smallImageURL;
	String birthdate;
	phoneObj phone;
	
	public contactObj(){
		
	}
	
	public contactObj(String name, int employeeId, String company,
			String detailsURL, String smallImageURL, String birthdate, phoneObj phone){
		this.name=name;
		this.employeeId=employeeId;
		this.company=company;
		this.detailsURL=detailsURL;
		this.smallImageURL=smallImageURL;
		this.birthdate=birthdate;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDetailsURL() {
		return detailsURL;
	}

	public void setDetailsURL(String detailsURL) {
		this.detailsURL = detailsURL;
	}

	public String getSmallImageURL() {
		return smallImageURL;
	}

	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public phoneObj getPhone() {
		return phone;
	}

	public void setPhone(phoneObj phone) {
		this.phone = phone;
	}
	
	
}