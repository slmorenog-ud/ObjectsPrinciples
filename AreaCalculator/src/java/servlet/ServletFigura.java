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
import logic.FactoryFigura;
import logic.Figura;

/**
 *
 * @author smore
 */
@WebServlet(name = "FiguraServlet", urlPatterns = {"/FiguraServlet"})
public class ServletFigura extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtenemos parámetros
        String tipo = request.getParameter("tipo");

        if (tipo == null || tipo.trim().isEmpty()) {
            mostrarError(response, "Debe seleccionar un tipo de figura.");
            return;
        }
        tipo = tipo.toLowerCase();
        
        try {
            // Creamos la figura usando el factory
            Figura figura = FactoryFigura.crearFigura(tipo);
            
            // Configuramos las dimensiones según el tipo
            if (tipo.equals("triangulo")) {
                double base = Double.parseDouble(request.getParameter("base"));
                double altura = Double.parseDouble(request.getParameter("altura"));
                figura.establecerDimensiones(base, altura);
            } else if (tipo.equals("cuadrilatero")) {
                double largo = Double.parseDouble(request.getParameter("largo"));
                double ancho = Double.parseDouble(request.getParameter("ancho"));
                figura.establecerDimensiones(largo, ancho);
            }
            
            // Calculamos el área
            double area = figura.calcularArea();
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Calculadora de Áreas</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
                out.println(".result { background-color: #f0f0f0; padding: 20px; border-radius: 8px; }");
                out.println("h1 { color: #333; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='result'>");
                out.println("<h1>Resultado del cálculo</h1>");
                out.println("<p><strong>Tipo de figura:</strong> " + figura.getTipo() + "</p>");
                
                if (tipo.equals("triangulo")) {
                    double[] dimensiones = figura.getDimensiones();
                    out.println("<p><strong>Base:</strong> " + dimensiones[0] + "</p>");
                    out.println("<p><strong>Altura:</strong> " + dimensiones[1] + "</p>");
                } else if (tipo.equals("cuadrilatero")) {
                    double[] dimensiones = figura.getDimensiones();
                    out.println("<p><strong>Largo:</strong> " + dimensiones[0] + "</p>");
                    out.println("<p><strong>Ancho:</strong> " + dimensiones[1] + "</p>");
                }
                
                out.println("<p><strong>Área calculada:</strong> " + area + "</p>");
                out.println("</div>");
                out.println("<p><a href='index.html'>Volver al formulario</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (NumberFormatException e) {
            // Error de formato en los números
            mostrarError(response, "Los valores ingresados deben ser números válidos.");
        } catch (IllegalArgumentException e) {
            // Error de tipo de figura no soportado
            mostrarError(response, e.getMessage());
        } catch (Exception e) {
            // Otros errores
            mostrarError(response, "Error al procesar la solicitud: " + e.getMessage());
        }
    }
    
    private void mostrarError(HttpServletResponse response, String mensaje) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error</title>");
            out.println("<style>body { font-family: Arial, sans-serif; margin: 40px; }");
            out.println(".error { background-color: #ffebee; color: #c62828; padding: 20px; border-radius: 8px; }</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='error'>");
            out.println("<h2>Error</h2>");
            out.println("<p>" + mensaje + "</p>");
            out.println("</div>");
            out.println("<p><a href='index.html'>Volver al formulario</a></p>");
            out.println("</body>");
            out.println("</html>");
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
        return "Calculadora de áreas de figuras geométricas";
    }
}