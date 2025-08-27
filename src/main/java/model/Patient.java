package model;

public class Patient extends User {
	 private String dateOfBirth;
	    private String gender;
	    private String emergencyContactNumber;
	    private String address;
	    private String bloodType;
	    private String doctorContactNumber;
	    private String medicalHistory;
	    private String currentMedication;
	    private String allergies;
	    private String doctor_email;
	    public Patient() {
	    	super();
	        this.setRole(Role.PATIENT);
	    }
	    public String getDoctorEmail() {
			return doctor_email;
		}
		public void setDoctorEmail(String doctor_email) {
			this.doctor_email = doctor_email;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEmergencyContactNumber() {
			return emergencyContactNumber;
		}
		public void setEmergencyContactNumber(String emergencyContactNumber) {
			this.emergencyContactNumber = emergencyContactNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBloodType() {
			return bloodType;
		}
		public void setBloodType(String bloodType) {
			this.bloodType = bloodType;
		}
		public String getDoctorContactNumber() {
			return doctorContactNumber;
		}
		public void setDoctorContactNumber(String doctorContactNumber) {
			this.doctorContactNumber = doctorContactNumber;
		}
		public String getMedicalHistory() {
			return medicalHistory;
		}
		public void setMedicalHistory(String medicalHistory) {
			this.medicalHistory = medicalHistory;
		}
		public String getCurrentMedication() {
			return currentMedication;
		}
		public void setCurrentMedication(String currentMedication) {
			this.currentMedication = currentMedication;
		}
		public String getAllergies() {
			return allergies;
		}
		public void setAllergies(String allergies) {
			this.allergies = allergies;
		}
	    
}
