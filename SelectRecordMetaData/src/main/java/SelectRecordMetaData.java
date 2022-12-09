

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectRecordMetaData
 */
@WebServlet("/SelectRecordMetaData")
public class SelectRecordMetaData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRecordMetaData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		  PrintWriter out=response.getWriter(); 
		  //String name=request.getParameter("uname"); 
		 
		  try 
		  { 
		  Class.forName("oracle.jdbc.driver.OracleDriver"); 
		 
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mjdbc","mjdbc"); 
		 
		  Statement ps=con.createStatement(); 
		  //ps.setString(1,name); 
		 
		  ResultSet rs=ps.executeQuery("select * from userdetails"); 
		 
		  ResultSetMetaData rss=rs.getMetaData(); 
		  out.print("<table border='1'>"); 
		 
		  int n=rss.getColumnCount();   
		  for(int i=1;i<=n;i++)     
		    
		  out.println("<td> <font color=blue size=3> "+"<br>" 
		  +rss.getColumnName(i)); 
		    
		   out.println("<tr>"); 
		    
		   while(rs.next()) 
		   { 
		   for(int i=1;i<=n;i++) 
		     
		   out.println("<td><br> "+rs.getString(i)); 
		   out.println("<tr>"); 
		   } 
		   out.println("</table> </body> </html>"); 
		   con.close();  } 
		  catch(Exception ex) 
		  { 
		   out.println(ex); 
		  } 
		 } 
		 
		}