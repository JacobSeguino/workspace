package objects;

public class phoneObj{
	String workP;
	String homeP;
	String mobileP;
	
	public phoneObj(){
		
	}
	
	public phoneObj(String workP, String homeP, String mobileP){
		this.workP = workP;
		this.homeP = homeP;
		this.mobileP = mobileP;
	}

	public String getWorkP() {
		return workP;
	}

	public void setWorkP(String workP) {
		this.workP = workP;
	}

	public String getHomeP() {
		return homeP;
	}

	public void setHomeP(String homeP) {
		this.homeP = homeP;
	}

	public String getMobileP() {
		return mobileP;
	}

	public void setMobileP(String mobileP) {
		this.mobileP = mobileP;
	}
	
	

}

