/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tag;
import model.Task;
import model.User;

/**
 *
 * @author Justin
 */
@WebServlet(name = "AddTaskServlet", urlPatterns =
{
    "/AddTaskServlet"
})
public class AddTaskServlet extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
    {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter())
	{
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet AddTaskServlet</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Servlet AddTaskServlet at " + request.getContextPath() + "</h1>");
	    out.println("</body>");
	    out.println("</html>");
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
    {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException
    {
	//processRequest(request, response);
	
	// title, description, calendar, taglist
	String userId = request.getParameter(User.COLUMN_ID);
	String title = request.getParameter(Task.COLUMN_TITLE);
	String description = request.getParameter(Task.COLUMN_DESCRIPTION);
	String schedule = request.getParameter(Task.COLUMN_SCHEDULE);
	String[] date = schedule.split("/");
	System.out.println(date[0] + " " + date[1] + " " + date[2]);
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date(Integer.parseInt(date[2]) - 1900, Integer.parseInt(date[0]) - 1, Integer.parseInt(date[1])));
	System.out.println("SHIT: " + calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR));
	
	ArrayList<Tag> tagList = new ArrayList<>();
	
	Task task = new Task(title, description, calendar, tagList);
	
	Controller controller = new Controller();
	
	//todo: change to userID when sessions are fixed
	int id = controller.insertTask("1", task);
	
	if( id != -999 )
	{
	    task.setTaskId(Integer.toString(id));
	}
	
	// return task
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
	return "Short description";
    }// </editor-fold>

}
