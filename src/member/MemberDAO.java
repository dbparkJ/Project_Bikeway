package member;
import java.sql.*; //Connection, Statement, PreparedStatement, ResultSet

import javax.sql.*; //DataSource

import db.DBConnection;

import javax.naming.*; //lookup

import java.util.*;

//DAO : 비지니스 로직, CRUD처리
public class MemberDAO {
	//싱글톤 객체사용(객채를 하나만 사용한다), 메모리 절약효과
	private static MemberDAO instance=new MemberDAO();//객체생성
		
	//생성자
	private MemberDAO(){} //private 이라 외부에서 객체생성 못함 자신의 클래스에서만 가능
	public static MemberDAO getDao(){ //jsp 사용할 메서드
		return instance;
	}//getDao-end	
	
	//전역변수
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
		//===============
		//id 중복체크
		//===============
		public int confirmEmail(String email){
			int x=-100; //변수
			
			try{
				con = DBConnection.getInstacne().getConnection();
				pstmt=con.prepareStatement("select email from member where email=?");
				
				pstmt.setString(1, email);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					x=1; //사용중인 id
				}else{
					x=-1; //사용가능 id
				}//else-end
			}catch(Exception ex){
				System.out.println("confirmEmail 예외 : "+ex);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}//finally-end
			return x;
		}//confirmID-end
		//===============
		//nickname 중복체크
		//===============
		public int confirmNickname(String nickname){
			int x=-100; //변수
			
			try{
				con = DBConnection.getInstacne().getConnection();
				pstmt=con.prepareStatement("select nickname from member where nickname=?");
				
				pstmt.setString(1, nickname);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					x=1; //사용중인 id
				}else{
					x=-1; //사용가능 id
				}//else-end
			}catch(Exception ex){
				System.out.println("confirmNickname 예외 : "+ex);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}//finally-end
			return x;
		}//confirmNickname-end

	//===============
	//로그인, 인증
	//===============
	public int userCheck(String email, String pw){
		int x=-100;
		String dbpw="";
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select * from member where email=?");
			
			pstmt.setString(1, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dbpw=rs.getString("password");
				
				if(pw.equals(dbpw)){//암호가 일치하면
					x=1; //인증성공
				}else{//암호가 일치하지 않으면
					x=0;
				}//else-end
			}else{
				x=-1; //없는 email
			}//else-end
		}catch(Exception ex){
			System.out.println("userCheck 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		return x;
	}//userCheck-end
	
	
	//===============
	//로그인 멤버 정보
	//===============
		public LoginMemberDTO getLoginMember(String email){
			LoginMemberDTO dto=null;
			
			try{
				con = DBConnection.getInstacne().getConnection();
				pstmt=con.prepareStatement("select * from member where email=?");
				
				pstmt.setString(1, email);
				rs=pstmt.executeQuery();
				
				//rs 내용을 dto에 넣고
				//dto를 리턴
				if(rs.next()){
					dto=new LoginMemberDTO(); //객체생성
					
					dto.setId(rs.getInt("id"));
					dto.setEmail(rs.getString("email"));
					dto.setNickname(rs.getString("nickname"));
					dto.setAddress(rs.getString("address"));
				}//if-end
				
			}catch(Exception ex){
				System.out.println("getMember 예외 : "+ex);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){}
			}//finally-end
			
			return dto;
		}//getLoginMember-end
	
	
	//===============
	//회원 정보 가져오기
	//===============
	public MemberDTO getMember(String email){
		MemberDTO dto=null;
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select * from member where email=?");
			
			pstmt.setString(1, email);
			
			rs=pstmt.executeQuery();
			
			//rs 내용을 dto에 넣고
			//dto를 리턴
			if(rs.next()){
				dto=new MemberDTO(); //객체생성
				
				dto.setId(rs.getInt("id"));
				dto.setEmail(rs.getString("email"));
				dto.setPassword(rs.getString("password"));
				dto.setNickname(rs.getString("nickname"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setWeight(rs.getDouble("weight"));
			
				dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
				dto.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
				
			}//if-end
			
		}catch(Exception ex){
			System.out.println("getMember 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		return dto;
	}//getMember-end
	
	public void insertMember(MemberDTO dto){
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("insert into member (email, password, nickname, name, address, zipcode, created_at, updated_at,ID,weight)"+
			" values(?,?,?,?,?,?, SYSDATE, SYSDATE,1,?)");
			//emp_seq.NEXTVAL,
			//?값 채우기
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setDouble(7, dto.getWeight());			

			pstmt.executeUpdate();// 쿼리 수행

		}catch(Exception ex){
			System.out.println("insertMember()얘외:"+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception exx){}
		}//finally-end
	}//메서드-end

	//===============
	//로그인, 인증
	//===============
	public int userCheck(String email, String pw, int a){
		int x=-100;
		String dbpw="";
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select * from member where email=?");
			
			pstmt.setString(1, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dbpw=rs.getString("password");
				
				if(pw.equals(dbpw)){//암호가 일치하면
					x=1; //인증성공
				}else{//암호가 일치하지 않으면
					x=0;
				}//else-end
			}else{
				x=-1; //없는 email
			}//else-end
		}catch(Exception ex){
			System.out.println("userCheck 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		return x;
	}//userCheck-end
	
	public int userCheck(Integer id, String pw){
		int x=-100;
		String dbpw="";
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select * from member where id=?");
			
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dbpw=rs.getString("password");
				
				if(pw.equals(dbpw)){//암호가 일치하면
					x=1; //인증성공
				}else{//암호가 일치하지 않으면
					x=0;
				}//else-end
			}else{
				x=-1; //없는 email
			}//else-end
		}catch(Exception ex){
			System.out.println("userCheck 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		return x;
	}//userCheck-end
	
	
}//class-end
