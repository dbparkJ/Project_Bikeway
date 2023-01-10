package bike;

public class CorseDTO {
	private String corse_name;
	private Double lon;
	private Double lat;
	private Double elev;
	public String getCorse_name() {
		return corse_name;
	}
	public void setCorse_name(String corse_name) {
		this.corse_name = corse_name;
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
	public Double getElev() {
		return elev;
	}
	public void setElev(Double elev) {
		this.elev = elev;
	}
	
}
