package riding;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class RidingDTO {
	
	private String email; // 아이디
	private Double distance; // 주행거리
	private Double calorie; // 칼로리
	private Integer riding_time; // 라이딩 한 시간
	private LocalDate riding_dt; // 라이딩 일자
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getCalorie() {
		return calorie;
	}
	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}
	public Integer getRiding_time() {
		return riding_time;
	}
	public void setRiding_time(Integer riding_time) {
		this.riding_time = riding_time;
	}
	public LocalDate getRiding_dt() {
		return riding_dt;
	}
	public void setRiding_dt(LocalDate riding_dt) {
		this.riding_dt = riding_dt;
	}
}
