/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.Animal;
import logic.Gato;
import logic.Mamifero;
import logic.Perro;

/**
 *
 * @author Estudiantes
 */
@WebServlet(name = "AnimalServlet", urlPatterns = {"/AnimalServlet"})
public class AnimalServlet extends HttpServlet {
    
    public static Animal a;
    public static void liskov(Animal ani,String nombre){
        ani.setNombre(nombre);
        ani.crearAnimal();
        a=ani;
    }
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
        String tipo=request.getParameter("especie");
        if (tipo.equals("Gato")){
            Gato g = new Gato();
            liskov(g,request.getParameter("nombre"));
        }else if(tipo.equals("Perro")){
            Perro p = new Perro();
            liskov(p,request.getParameter("nombre"));
        }else{
            Mamifero m = new Mamifero();
            liskov(m,request.getParameter("nombre"));
        }
        
        
        //Mamifero m = new Mamifero();
        //m.setNombre(request.getParameter("nombre"));
        //m.crearAnimal();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnimalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>el animal " + a.getTipo() + "</h1>");
            out.println("<h1>el animal " + a.getHabitat() + "</h1>");
            out.println("<h1>el animal " + a.getNombre() + "</h1>");
            out.println("<h1>el animal " + a.getComida() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
