package riding;

import java.time.LocalDateTime;

public class RidingDTO {
	
	private int id; // 아이디
	private Integer distance; // 주행거리
	private Integer calorie; // 칼로리
	private Integer riding_time; // 라이딩 한 시간
	private LocalDateTime riding_dt; // 라이딩 일자
	
	// getter, setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Integer getCalorie() {
		return calorie;
	}
	public void setCalorie(Integer calorie) {
		this.calorie = calorie;
	}
	public Integer getRiding_time() {
		return riding_time;
	}
	public void setRiding_time(Integer riding_time) {
		this.riding_time = riding_time;
	}
	public LocalDateTime getRiding_dt() {
		return riding_dt;
	}
	public void setRiding_dt(LocalDateTime riding_dt) {
		this.riding_dt = riding_dt;
	}
	
}
