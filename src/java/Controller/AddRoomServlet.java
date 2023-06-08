/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;


import DAOS.DAOS;
import Model.Account; 
import Model.Room;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException; 


/**
 *
 * @author caokhanh
 */
public class AddRoomServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String img = request.getParameter("img");

        String roomID = request.getParameter("roomID");
        int roomid = Integer.parseInt(roomID);

        String price = request.getParameter("price");
        int Price = Integer.parseInt(price);

        String address = request.getParameter("address");

        String numberpeople = request.getParameter("numberpeople");
        int numberOfpeople = Integer.parseInt(numberpeople);

        String typeroom = request.getParameter("type");
        int typeRoom = Integer.parseInt(typeroom);

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String ownerID = a.getUserID();
        
        DAOS dao = new DAOS();

        Room r = dao.checkRoomIDExist(roomid);
        if (r == null) {
            dao.insert(roomid, img, Price,numberOfpeople ,address,typeRoom , ownerID );
            response.sendRedirect("ManagerServlet");
        } else {
            request.setAttribute("err","Room ID =" +roomid + " EXIST!!!!!!!!!!!!!!!!!!!!");
            request.getRequestDispatcher("addroom.jsp").forward(request, response);
        }
//        dao.insert(roomid, img, Price,numberOfpeople ,address,typeRoom , ownerID,userid );
//        response.sendRedirect("ManagerServlet");
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
