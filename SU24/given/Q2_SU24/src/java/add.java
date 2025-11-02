/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/add"})
public class add extends HttpServlet {

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
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String pos = request.getParameter("pos");
        String shirt_num = request.getParameter("shirt_num");

        HttpSession session = request.getSession();
        ArrayList<Player> list = new ArrayList<>();
        ArrayList<Player> listFromSession = (ArrayList<Player>) session.getAttribute("list");

        //check exist
        if (checkExist(listFromSession, code)) {

            request.setAttribute("err", "Player existed!");
        } else {
            if (listFromSession != null) {
                list = (ArrayList<Player>) session.getAttribute("list");
            }

            list.add(new Player(code, name, pos, shirt_num));
            session.setAttribute("list", list);

        }

        request.setAttribute("code", code);
        request.setAttribute("name", name);
        request.setAttribute("pos", pos);
        request.setAttribute("shirt_num", shirt_num);
        request.getRequestDispatcher("MyPlayer.jsp").forward(request, response);

    }

    boolean checkExist(ArrayList<Player> listFromSession, String code) {
        if (listFromSession == null) {
            return false;
        }

        for (Player player : listFromSession) {
            if (player.getCode().equals(code)) {
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
