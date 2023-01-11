package bike;

import java.time.LocalDateTime;

public class RentBikeInfoDTO {
	private String stationName;
	private Integer rackToCnt;
	private Integer bikeToCnt;
	private Double lon;
	private Double lat;
	private String stationId;
	private LocalDateTime updateTime;
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Integer getRackToCnt() {
		return rackToCnt;
	}
	public void setRackToCnt(Integer rackToCnt) {
		this.rackToCnt = rackToCnt;
	}
	public Integer getBikeToCnt() {
		return bikeToCnt;
	}
	public void setBikeToCnt(Integer bikeToCnt) {
		this.bikeToCnt = bikeToCnt;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
}
