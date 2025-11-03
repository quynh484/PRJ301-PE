/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class execute extends HttpServlet {

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
        String txta = request.getParameter("txta");
        String txtb = request.getParameter("txtb");
//        String txtOutput = request.getParameter("txtOutput");

        HttpSession session = request.getSession();
        ArrayList<Execution> list = new ArrayList<>();
        ArrayList<Execution> listFromSession = (ArrayList<Execution>) session.getAttribute("list");

        int a = Integer.parseInt(txta);
        int b = Integer.parseInt(txtb);
        //check exist
        if (checkExist(listFromSession, a, b)) {
            request.setAttribute("err", "Execution existed!");
        } else {
            if (listFromSession != null) {
                list = (ArrayList<Execution>) session.getAttribute("list");
            }

            int result = calculate(a, b);
            list.add(new Execution(a, b, result));
            session.setAttribute("list", list);
            request.setAttribute("txtOutput", result);
        }

//        request.setAttribute("code", code);
//        request.setAttribute("name", name);
//        request.setAttribute("pos", pos);
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);

    }

    int calculate(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    boolean checkExist(ArrayList<Execution> listFromSession, int a, int b) {
        if (listFromSession == null) {
            return false;
        }

        for (Execution ex : listFromSession) {
            if (ex.getA() == a && ex.getB() == b) {
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
