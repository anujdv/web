import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
public class Reg extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{	
		try{
			PrintWriter out = res.getWriter();
			// output content type
			res.setContentType("text/html");
			//to establish jdbc connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/18131a05p3","root","");
			//insert into registration table of 18131a05p3 database
			PreparedStatement ps = con.prepareStatement("insert into registration values(?,?,?,?)");
			//get value of user,pass,mail,phone from index.html
			String user = req.getParameter("u");
			String pass = req.getParameter("p");
			String mail= req.getParameter("m");
			String phone = req.getParameter("ph");
		    //insert the values into the registration table
			ps.setString(1,user);
			ps.setString(2,pass);
			ps.setString(3,mail);
			ps.setString(4,phone);
			// if inserted i will get the number of rows insert which is 1 in our case executeUpdate() returns the number of rows affected by Insert statement
			int i=ps.executeUpdate();
			if(i!=0)
				out.println("<html><body><b>Successfully Inserted"+"</b></body></html>");
		}
		catch(Exception e){
			System.out.println("Failed to insert.");
			System.out.println(e);
		}
	}
} 
