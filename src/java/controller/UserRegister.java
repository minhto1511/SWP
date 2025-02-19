/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.User;
import model.DAOUser;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Heizxje
 */
@WebServlet(name = "UserRegister", urlPatterns = {"/User"})
public class UserRegister extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOUser dao = new DAOUser();
            String service = request.getParameter("service");
            if (service.equals("registerUser")) {
                String error = "";
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                if (submit != null) {
                    String roleID = request.getParameter("RoleID");
                    String email = request.getParameter("Email");
                    String fullName = request.getParameter("FullName");
                    String phone = request.getParameter("Phone");
                    String dob = request.getParameter("Dob");
                    String address = request.getParameter("Address");
                    String avatar = request.getParameter("Avatar");
                    String userName = request.getParameter("UserName");
                    String password = request.getParameter("Password");
                    try {
                        if (password.length() < 8) {
                            error = "Password must be more than 8 character";
                        }else{
                            int n = dao.registerUser(new User(0, Integer.parseInt(roleID), email, fullName, phone, null, 1, Date.valueOf(dob), address, avatar, userName, password));
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }
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
