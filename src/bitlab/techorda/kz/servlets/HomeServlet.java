package bitlab.techorda.kz.servlets;

import bitlab.techorda.kz.classes.DBConnection;
import bitlab.techorda.kz.classes.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ArrayList<Item> items =DBConnection.getItems();

        request.setAttribute("zattar", items);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
