package model;

public class Doctor extends User {
	  private String contactNumber;

	    //constructors
	    public Doctor() {
	        super();
	    }

	    public Doctor(Long id, String username, String password, String email, Role role) {
	        super(id, username, password, email, role);
	    }

	    //getters and setters
	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }
}
