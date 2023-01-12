package weather;

import java.util.*;

// 주간강수조회 .

public class WeatherRainDTO {
	private String areaname;

	private int rain_1_am;		// 1일 강수 확률 오전
	private String weather_1_am; //	1일 날씨 상태 오전
	private int rain_1_pm;	//	1일 강수 확률 오후
	private String weather_1_pm; //	1일 날씨 상태 오후
	
	private int rain_2_am;		// 2일 강수 확률 오전
	private String weather_2_am; //	2일 날씨 상태 오전
	private int rain_2_pm;	//	2일 강수 확률 오후
	private String weather_2_pm; //	2일 날씨 상태 오후
	
	private int rain_3_am;		// 3일 강수 확률 오전
	private String weather_3_am; //	3일 날씨 상태 오전
	private int rain_3_pm;	//	3일 강수 확률 오후
	private String weather_3_pm; //	3일 날씨 상태 오후
	
	private int rain_4_am;		// 4일 강수 확률 오전
	private String weather_4_am; //	4일 날씨 상태 오전
	private int rain_4_pm;	//	4일 강수 확률 오후
	private String weather_4_pm; //	4일 날씨 상태 오후
	
	private int rain_5_am;		// 5일 강수 확률 오전
	private String weather_5_am; //	5일 날씨 상태 오전
	private int rain_5_pm;	//	5일 강수 확률 오후
	private String weather_5_pm; //	5일 날씨 상태 오후

	
	private Date updatetime;	//	제공시각

	// 게터 세터 .
	public String getAreaname() {
		return areaname;
	}


	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}


	public int getRain_1_am() {
		return rain_1_am;
	}


	public void setRain_1_am(int rain_1_am) {
		this.rain_1_am = rain_1_am;
	}


	public String getWeather_1_am() {
		return weather_1_am;
	}


	public void setWeather_1_am(String weather_1_am) {
		this.weather_1_am = weather_1_am;
	}


	public int getRain_1_pm() {
		return rain_1_pm;
	}


	public void setRain_1_pm(int rain_1_pm) {
		this.rain_1_pm = rain_1_pm;
	}


	public String getWeather_1_pm() {
		return weather_1_pm;
	}


	public void setWeather_1_pm(String weather_1_pm) {
		this.weather_1_pm = weather_1_pm;
	}


	public int getRain_2_am() {
		return rain_2_am;
	}


	public void setRain_2_am(int rain_2_am) {
		this.rain_2_am = rain_2_am;
	}


	public String getWeather_2_am() {
		return weather_2_am;
	}


	public void setWeather_2_am(String weather_2_am) {
		this.weather_2_am = weather_2_am;
	}


	public int getRain_2_pm() {
		return rain_2_pm;
	}


	public void setRain_2_pm(int rain_2_pm) {
		this.rain_2_pm = rain_2_pm;
	}


	public String getWeather_2_pm() {
		return weather_2_pm;
	}


	public void setWeather_2_pm(String weather_2_pm) {
		this.weather_2_pm = weather_2_pm;
	}


	public int getRain_3_am() {
		return rain_3_am;
	}


	public void setRain_3_am(int rain_3_am) {
		this.rain_3_am = rain_3_am;
	}


	public String getWeather_3_am() {
		return weather_3_am;
	}


	public void setWeather_3_am(String weather_3_am) {
		this.weather_3_am = weather_3_am;
	}


	public int getRain_3_pm() {
		return rain_3_pm;
	}


	public void setRain_3_pm(int rain_3_pm) {
		this.rain_3_pm = rain_3_pm;
	}


	public String getWeather_3_pm() {
		return weather_3_pm;
	}


	public void setWeather_3_pm(String weather_3_pm) {
		this.weather_3_pm = weather_3_pm;
	}


	public int getRain_4_am() {
		return rain_4_am;
	}


	public void setRain_4_am(int rain_4_am) {
		this.rain_4_am = rain_4_am;
	}


	public String getWeather_4_am() {
		return weather_4_am;
	}


	public void setWeather_4_am(String weather_4_am) {
		this.weather_4_am = weather_4_am;
	}


	public int getRain_4_pm() {
		return rain_4_pm;
	}


	public void setRain_4_pm(int rain_4_pm) {
		this.rain_4_pm = rain_4_pm;
	}


	public String getWeather_4_pm() {
		return weather_4_pm;
	}


	public void setWeather_4_pm(String weather_4_pm) {
		this.weather_4_pm = weather_4_pm;
	}


	public int getRain_5_am() {
		return rain_5_am;
	}


	public void setRain_5_am(int rain_5_am) {
		this.rain_5_am = rain_5_am;
	}


	public String getWeather_5_am() {
		return weather_5_am;
	}


	public void setWeather_5_am(String weather_5_am) {
		this.weather_5_am = weather_5_am;
	}


	public int getRain_5_pm() {
		return rain_5_pm;
	}


	public void setRain_5_pm(int rain_5_pm) {
		this.rain_5_pm = rain_5_pm;
	}


	public String getWeather_5_pm() {
		return weather_5_pm;
	}


	public void setWeather_5_pm(String weather_5_pm) {
		this.weather_5_pm = weather_5_pm;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	




}
