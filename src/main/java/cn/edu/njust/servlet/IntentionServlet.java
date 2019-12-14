package cn.edu.njust.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import cn.edu.njust.dao.ConfirmDao;
import cn.edu.njust.dao.ScoreDao;

/**
 * Servlet implementation class IntentionServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/IntentionServlet" })
public class IntentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntentionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        ConfirmDao dao = new ConfirmDao();
        if(request.getParameterValues("stuid") == null) {
        	out.print("<script>");
			out.print("alert('Please pick what you want to delete.');");
			out.print("window.location.href='jsp/managerIntention.jsp'");
			out.print("</script>");
			out.close();	
        } else {
        	String stuid[] = request.getParameterValues("stuID");
        	for(int i = 0; i < stuid.length; i++) {
        		try {
        			if(!dao.inConfirm(stuid[i])&&dao.addConfirm(stuid[i])) {
        				JOptionPane.showMessageDialog(null, "添加成功！");
        			    response.sendRedirect("../jsp/managerIntention.jsp");
        			    return;
        			} else {
        				JOptionPane.showMessageDialog(null, "未知原因，添加失败！");
        			    response.sendRedirect("../jsp/managerIntention.jsp");
        			}
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        	}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
