/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy đối tượng session hiện tại và hủy nó
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // Hủy session để đăng xuất
        }

        // Chuyển hướng người dùng đến trang đăng nhập hoặc trang chủ
        response.sendRedirect("login.jsp");  // Hoặc có thể chuyển hướng đến trang khác
    }
    public static void main(String[] args) {
        System.out.println("sss");
    }
}
