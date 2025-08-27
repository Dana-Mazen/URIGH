package dao;

import model.Patient;
import model.User;
import model.User.Role;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class userDAO {
	//register a new user(patient or doctor)
    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, password, email, role, full_name, contact_number, " +
                     "notifications_enabled, preferred_communication_method, health_data_visible, " +
                     "share_data_with_third_parties, language, dark_mode_enabled, emergency_contact, is_active) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //////////////////////////
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole().toString());
            stmt.setString(5, user.getFullName());
            stmt.setString(6, user.getContactNumber());
            stmt.setBoolean(7, user.isNotificationsEnabled());
            stmt.setString(8, user.getPreferredCommunicationMethod());
            stmt.setBoolean(9, user.isHealthDataVisible());
            stmt.setBoolean(10, user.isShareDataWithThirdParties());
            stmt.setString(11, user.getLanguage());
            stmt.setBoolean(12, user.isDarkModeEnabled());
            stmt.setString(13, user.getEmergencyContact());
            stmt.setBoolean(14, user.isActive());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace(); //log instead
            return false;
        }
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = extractUserFromResultSet(rs);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    //map DB row to User object
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setRole(Role.valueOf(rs.getString("role")));
        user.setFullName(rs.getString("full_name"));
        user.setContactNumber(rs.getString("contact_number"));
        user.setNotificationsEnabled(rs.getBoolean("notifications_enabled"));
        user.setPreferredCommunicationMethod(rs.getString("preferred_communication_method"));
        user.setHealthDataVisible(rs.getBoolean("health_data_visible"));
        user.setShareDataWithThirdParties(rs.getBoolean("share_data_with_third_parties"));
        user.setLanguage(rs.getString("language"));
        user.setDarkModeEnabled(rs.getBoolean("dark_mode_enabled"));
        user.setEmergencyContact(rs.getString("emergency_contact"));
        user.setActive(rs.getBoolean("is_active"));
        
        return user;
    }
    public List<User> getAllPatients() {
        List<User> patients = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'PATIENT'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = extractUserFromResultSet(rs);
                patients.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // log it
        }
        return patients;
    }
    public boolean updateUser(User user) {
        String sql = "UPDATE user SET username=?, password=?, email=?, full_name=?, contact_number=?, " +
                     "notifications_enabled=?, preferred_communication_method=?, health_data_visible=?, " +
                     "share_data_with_third_parties=?, language=?, dark_mode_enabled=?, emergency_contact=?, is_active=?, address=?, blood_type=?, allergies=?, medical_history=?, current_medication=?, doctor_email=?" +
                     "WHERE id=?";
          //no update role to avoid security issues
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	/////////////////////////////
        	if (user.getId() == null) {
           System.err.println("Cannot update user: ID is null.");
            return false;}
            //just for checking
        	System.out.println("Updating user with ID: " + user.getId());
        	System.out.println("Username: " + user.getUsername());
        	
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getFullName());
            stmt.setString(5, user.getContactNumber());
            stmt.setBoolean(6, user.isNotificationsEnabled());
            stmt.setString(7, user.getPreferredCommunicationMethod());
            stmt.setBoolean(8, user.isHealthDataVisible());
            stmt.setBoolean(9, user.isShareDataWithThirdParties());
            stmt.setString(10, user.getLanguage());
            stmt.setBoolean(11, user.isDarkModeEnabled());
            stmt.setString(12, user.getEmergencyContact());
            stmt.setBoolean(13, user.isActive());
            stmt.setString(14, ((Patient) user).getAddress());
            stmt.setString(15, ((Patient) user).getBloodType());
            stmt.setString(16, ((Patient) user).getAllergies());
            stmt.setString(17, ((Patient) user).getMedicalHistory());
            stmt.setString(18, ((Patient) user).getCurrentMedication());
            stmt.setString(19, ((Patient) user).getDoctorEmail());
            stmt.setLong(20, user.getId());

         //   return stmt.executeUpdate() > 0;
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = extractUserFromResultSet(rs);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
