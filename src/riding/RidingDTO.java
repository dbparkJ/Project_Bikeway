package riding;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class RidingDTO {
	
	private int id; // 아이디
	private double distance; // 주행거리
	private double calorie; // 칼로리
	private int riding_time; // 라이딩 한 시간
	private LocalDate riding_dt; // 라이딩 일자
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getCalorie() {
		return calorie;
	}
	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	public int getRiding_time() {
		return riding_time;
	}
	public void setRiding_time(int riding_time) {
		this.riding_time = riding_time;
	}
	public LocalDate getRiding_dt() {
		return riding_dt;
	}
	public void setRiding_dt(LocalDate riding_dt) {
		this.riding_dt = riding_dt;
	}
	
	
}
