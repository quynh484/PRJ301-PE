/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ObjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Object;

/**
 *
 * @author admin
 */
public class post extends HttpServlet {

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
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String comment = request.getParameter("comment");
        String action = request.getParameter("action");

        ObjectDAO dao = new ObjectDAO();
        List<Account> listAccount = dao.findAccountList();
        request.setAttribute("listAccount", listAccount);

        if (account != null && password != null &&
                !account.isEmpty() && !password.isEmpty()) {
            if (!isValid(account, password, listAccount)) {
                request.setAttribute("err", "Password is wrong");
            } else if ("add".equals(action)) {
                dao.add(new Object(comment, account, new Date()));
            }
        }
        request.setAttribute("account", account);
        request.setAttribute("password", password);
        request.setAttribute("comment", comment);

        List<Object> list = dao.find();

        request.setAttribute(
                "list", list);

        request.getRequestDispatcher(
                "list.jsp").forward(request, response);
    }

    boolean isValid(String inputAcc, String pass, List<Account> listAcc) {
        for (Account account : listAcc) {
            if (account.getAccount().equals(inputAcc)
                    && account.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
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
