package riding;

import java.util.*;
import java.time.LocalDateTime;
import java.util.Date;

public class RidingDTO {
	
	private int id; // 아이디
	private float distance; // 주행거리
	private float calorie; // 칼로리
	private float riding_time; // 라이딩 한 시간
	private LocalDateTime riding_dt; // 라이딩 일자
	
	// 게터세터
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getCalorie() {
		return calorie;
	}
	public void setCalorie(float calorie) {
		this.calorie = calorie;
	}
	public float getRiding_time() {
		return riding_time;
	}
	public void setRiding_time(float riding_time) {
		this.riding_time = riding_time;
	}
	public LocalDateTime getRiding_dt() {
		return riding_dt;
	}
	public void setRiding_dt(LocalDateTime riding_dt) {
		this.riding_dt = riding_dt;
	}
	
	
	
	
}
