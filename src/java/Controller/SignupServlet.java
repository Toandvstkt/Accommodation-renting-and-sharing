/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import DAOS.DAOS;
import Model.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class SignupServlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String user=request.getParameter("userid");
        String fullname=request.getParameter("fullname");
        String email=request.getParameter("email");
        String tel=request.getParameter("tel");
        String pass=request.getParameter("pass");
        String role=request.getParameter("role");
        DAOS dao = new DAOS();
        boolean check=dao.checkAccountExist(user);
               if(check){
                   dao.signup(user,fullname,email,tel,pass,role);
           response.sendRedirect("home.jsp");
               }
               else{
                   response.sendRedirect("home.jsp");
               }
        
        
        
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
