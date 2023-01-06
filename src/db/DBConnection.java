package db;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection 
{
    public static Connection dbCon;
    
        public static Connection getConnection()
        {
            Connection con = null;
            try {
                String user = "bike"; 
                String pw = "12345";
                String url = "jdbc:oracle:thin:@192.168.0.78:1521:xe";
                
                Class.forName("oracle.jdbc.driver.OracleDriver");        
                con = DriverManager.getConnection(url, user, pw);
                
                System.out.println("Database에 연결되었습니다.\n");
                
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB 접속실패 : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unkonwn error");
                e.printStackTrace();
            }
            return con;     
        }
}