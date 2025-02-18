/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import model.DAOUser;
import entity.GoogleAccount;
import entity.User;
import controller.GoogleLogin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Heizxje
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        DAOUser dao = new DAOUser();

        String service = request.getParameter("service");

        if (service == null) {
            service = "googleLogin"; // Mặc định là login bằng Google nếu không có gì được truyền vào
        }

        switch (service) {
            case "googleLogin":
                handleGoogleLogin(request, response, session, dao);
                break;

            case "loginUser":
                handleUserLogin(request, response, session, dao);
                break;

            default:
                request.setAttribute("error", "Dịch vụ đăng nhập không hợp lệ.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
        }
    }

    private void handleGoogleLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, DAOUser dao)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String error = request.getParameter("error");

        if (error != null) {
            request.setAttribute("error", "Bạn đã từ chối quyền truy cập Google");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (code != null) {
            GoogleLogin gg = new GoogleLogin();
            String accessToken = gg.getToken(code);
            GoogleAccount googleAccount = gg.getUserInfo(accessToken);

            if (googleAccount != null) {
                User user = dao.getUserByEmail(googleAccount.getEmail());

                if (user == null) {
                    request.setAttribute("error", "Tài khoản Google chưa được đăng ký trong hệ thống.");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    session.setAttribute("user", user);
                    response.sendRedirect("home.jsp");
                }
            } else {
                request.setAttribute("error", "Không lấy được thông tin tài khoản Google.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleUserLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, DAOUser dao)
            throws ServletException, IOException {
        String submit = request.getParameter("submit");
        if (submit == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = dao.Login(username, password);
            if (user == null) {
                request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("home.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Login Servlet";
    }
}
