package corse;

public class CorseDTO {
	private String corse_name;
	private long lon;
	private long lat;
	private long elev;
	public String getCorse_name() {
		return corse_name;
	}
	public void setCorse_name(String corse_name) {
		this.corse_name = corse_name;
	}
	public long getLon() {
		return lon;
	}
	public void setLon(long lon) {
		this.lon = lon;
	}
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}
	public long getElev() {
		return elev;
	}
	public void setElev(long elev) {
		this.elev = elev;
	}
	
}
