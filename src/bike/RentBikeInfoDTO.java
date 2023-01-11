package bike;

import java.time.LocalDateTime;

public class RentBikeInfoDTO {
	private String stationName;
	private Integer rackToCnt;
	private Integer parkingBikeToCnt;
	private Double lat;
	private Double lon;
	private String stationId;
	private LocalDateTime updatetime;
	
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
	public Integer getParkingBikeToCnt() {
		return parkingBikeToCnt;
	}
	public void setParkingBikeToCnt(Integer parkingBikeToCnt) {
		this.parkingBikeToCnt = parkingBikeToCnt;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public LocalDateTime getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}
	
}
