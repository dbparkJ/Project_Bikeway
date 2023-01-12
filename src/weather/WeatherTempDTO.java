package weather;

import java.util.*;

// 주간기온조회 .

public class WeatherTempDTO {
	private String areaname;	//지역명

	private int lowtemp_1;		//	1일 최저기온
	private int hightemp_1;		//	1일 최고기온
	
	private int lowtemp_2;		//	2일 최저기온
	private int hightemp_2;		//	2일 최고기온

	private int lowtemp_3;		//	3일 최저기온
	private int hightemp_3;		//	3일 최고기온

	private int lowtemp_4;		//	4일 최저기온
	private int hightemp_4;		//	4일 최고기온
	
	private int lowtemp_5;		//	5일 최저기온
	private int hightemp_5;		//	5일 최고기온

	private Date updatetime;		// 제공시각
	
	
	// 게터 세터.
	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public int getLowtemp_1() {
		return lowtemp_1;
	}

	public void setLowtemp_1(int lowtemp_1) {
		this.lowtemp_1 = lowtemp_1;
	}

	public int getHightemp_1() {
		return hightemp_1;
	}

	public void setHightemp_1(int hightemp_1) {
		this.hightemp_1 = hightemp_1;
	}

	public int getLowtemp_2() {
		return lowtemp_2;
	}

	public void setLowtemp_2(int lowtemp_2) {
		this.lowtemp_2 = lowtemp_2;
	}

	public int getHightemp_2() {
		return hightemp_2;
	}

	public void setHightemp_2(int hightemp_2) {
		this.hightemp_2 = hightemp_2;
	}

	public int getLowtemp_3() {
		return lowtemp_3;
	}

	public void setLowtemp_3(int lowtemp_3) {
		this.lowtemp_3 = lowtemp_3;
	}

	public int getHightemp_3() {
		return hightemp_3;
	}

	public void setHightemp_3(int hightemp_3) {
		this.hightemp_3 = hightemp_3;
	}

	public int getLowtemp_4() {
		return lowtemp_4;
	}

	public void setLowtemp_4(int lowtemp_4) {
		this.lowtemp_4 = lowtemp_4;
	}

	public int getHightemp_4() {
		return hightemp_4;
	}

	public void setHightemp_4(int hightemp_4) {
		this.hightemp_4 = hightemp_4;
	}

	public int getLowtemp_5() {
		return lowtemp_5;
	}

	public void setLowtemp_5(int lowtemp_5) {
		this.lowtemp_5 = lowtemp_5;
	}

	public int getHightemp_5() {
		return hightemp_5;
	}

	public void setHightemp_5(int hightemp_5) {
		this.hightemp_5 = hightemp_5;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	

}
