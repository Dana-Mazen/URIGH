package model;

import java.util.Date;

public class HealthMetric {
	private Date date;
    private String heart_rate;
    private String blood_pressure;
    private String blood_sugar;
    public HealthMetric(Date date, String heart_rate, String blood_pressure, String blood_sugar) {
    	this.date = date;
    	this.heart_rate = heart_rate;
    	this.blood_pressure = blood_pressure;
    	this.blood_sugar = blood_sugar;
    }
	public HealthMetric() {
		// TODO Auto-generated constructor stub
	}
	public String getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(String heart_rate) {
		this.heart_rate = heart_rate;
	}
	public String getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(String blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public String getBlood_sugar() {
		return blood_sugar;
	}
	public void setBlood_sugar(String blood_sugar) {
		this.blood_sugar = blood_sugar;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
}
