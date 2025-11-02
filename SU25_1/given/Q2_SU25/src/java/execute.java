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
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
//        String txtOutput = request.getParameter("txtOutput");

        HttpSession session = request.getSession();
        ArrayList<BMI> list = new ArrayList<>();
        ArrayList<BMI> listFromSession = (ArrayList<BMI>) session.getAttribute("list");

        int height_num = Integer.parseInt(height);
        int weight_num = Integer.parseInt(weight);
//        PrintWriter out = response.getWriter();

        if (height_num < 10 || weight_num < 10) {
            request.setAttribute("err", "Height/Weight must be an integer >=10");

        }
        //check exist
        else if (!checkExist(listFromSession, height_num, weight_num)) {
            if (listFromSession != null) {
                list = (ArrayList<BMI>) session.getAttribute("list");
            }

            double bmi = weight_num/(((double)height_num/100)*((double)height_num/100));
            
            String conclude ="";
            if(bmi < 18.5) conclude = "Underweight";
            else if(bmi < 25) conclude = "Normal";
            else if(bmi < 30) conclude = "Slightly overweight";
            else conclude = "Obese";

            
            list.add(new BMI(height_num, weight_num, String.format("%.1f", bmi), conclude));
            session.setAttribute("list", list);
            System.out.println("list: " + list.get(0).toString());
            request.setAttribute("txtOutput", conclude);
        }

//        request.setAttribute("code", code);
//        request.setAttribute("name", name);
//        request.setAttribute("pos", pos);
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);

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

    boolean checkExist(ArrayList<BMI> listFromSession, int a, int b) {
        if (listFromSession == null) {
            return false;
        }

        for (BMI ex : listFromSession) {
            if (ex.getHeight() == a && ex.getWeight() == b) {
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
