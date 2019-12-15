package cn.edu.njust.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class CloseServlet
 */
@WebServlet("/CloseServlet")
public class CloseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        ServletContext sc = getServletConfig().getServletContext(); 
        if(sc.getAttribute("open") == null) {
        	sc.setAttribute("open", 0);
        }
        int op = (int) sc.getAttribute("open");
        if(op == 0) {
        	JOptionPane.showMessageDialog(null, "团报入口已经关闭！");
        }else {
        	sc.setAttribute("open", 0);
        	//sc.setAttribute("score", request.getParameter("score"));
        }   
        
        response.sendRedirect("../jsp/managerOpen.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
