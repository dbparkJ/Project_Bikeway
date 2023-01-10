package member;

import java.time.LocalDateTime;

public class MemberDTO {
	//전역변수=필드=property= 속성
	
	private String email;
	private String password;
	private String nickname;
	private String name;	
	private String address;	
	private String zipcode;	
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Integer id;
	private Double weight;
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getNickname() {
		return nickname;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public Integer getId() {
		return id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}

		
}