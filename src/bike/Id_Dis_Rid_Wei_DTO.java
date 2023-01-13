package bike;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Id_Dis_Rid_Wei_DTO {
	private String id;
	private Double distance;
	private Double riding_time;
	private Double weight;
	private LocalDate riding_dt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getRiding_time() {
		return riding_time;
	}
	public void setRiding_time(Double riding_time) {
		this.riding_time = riding_time;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public LocalDate getRiding_dt() {
		return riding_dt;
	}
	public void setRiding_dt(LocalDate riding_dt) {
		this.riding_dt = riding_dt;
	}

}
