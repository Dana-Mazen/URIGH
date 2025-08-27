package model;

public class User {
     public enum Role {
	        PATIENT, DOCTOR
	    }

	   private Long id;
	   private String fullName;
	   private String contactNumber;
	   private boolean notificationsEnabled;
	   private String preferredCommunicationMethod;
	   private boolean healthDataVisible;
	   private boolean shareDataWithThirdParties;
	   private String language;
	   private boolean darkModeEnabled;
	   private String emergencyContact;
	   private boolean isActive;
	   private String username;
	   private String password;
	   private String email;
	   private Role role;

	    //constructors
	    public User() {}

	    public User(Long id, String username, String password, String email, Role role) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.email = email;
	        this.role = role;
	    }


	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getFullName() { return fullName; }
	    public void setFullName(String fullName) { this.fullName = fullName; }

	    public String getContactNumber() { return contactNumber; }
	    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

	    public boolean isNotificationsEnabled() { return notificationsEnabled; }
	    public void setNotificationsEnabled(boolean notificationsEnabled) { this.notificationsEnabled = notificationsEnabled; }

	    public String getPreferredCommunicationMethod() { return preferredCommunicationMethod; }
	    public void setPreferredCommunicationMethod(String preferredCommunicationMethod) { this.preferredCommunicationMethod = preferredCommunicationMethod; }

	    public boolean isHealthDataVisible() { return healthDataVisible; }
	    public void setHealthDataVisible(boolean healthDataVisible) { this.healthDataVisible = healthDataVisible; }

	    public boolean isShareDataWithThirdParties() { return shareDataWithThirdParties; }
	    public void setShareDataWithThirdParties(boolean shareDataWithThirdParties) { this.shareDataWithThirdParties = shareDataWithThirdParties; }

	    public String getLanguage() { return language; }
	    public void setLanguage(String language) { this.language = language; }

	    public boolean isDarkModeEnabled() { return darkModeEnabled; }
	    public void setDarkModeEnabled(boolean darkModeEnabled) { this.darkModeEnabled = darkModeEnabled; }

	    public String getEmergencyContact() { return emergencyContact; }
	    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

	    public boolean isActive() { return isActive; }
	    public void setActive(boolean active) { isActive = active; }

	    public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public Role getRole() { return role; }
	    public void setRole(Role role) { this.role = role; }

	    @Override
	    public String toString() {
	        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	    }
}
