package controller;

import dal.ObjectDAO;
import model.Object;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ObjectController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ObjectDAO dao = new ObjectDAO();

        if ("delete".equals(action)) {
            dao.delete(req.getParameter("code"));
        }

        if ("edit".equals(action)) {
            req.setAttribute("editObj", dao.get(req.getParameter("code")));
        }

        if ("sort".equals(action)) {
            String sortName = req.getParameter("sortName"); // asc / desc
            String sortAddress = req.getParameter("sortAddress"); // asc / desc

            List<Object> list = dao.sort(sortName, sortAddress);
            req.setAttribute("list", list);
        } else {
            req.setAttribute("list", dao.find(req.getParameter("search")));
        }
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectDAO dao = new ObjectDAO();

        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");

        Object o = new Object(code, name, java.sql.Date.valueOf(dob), gender, address);

        if ("update".equals(req.getParameter("action"))) {
            dao.update(o);
        } else {
            dao.add(o);
        }

        resp.sendRedirect("list");
    }
}
