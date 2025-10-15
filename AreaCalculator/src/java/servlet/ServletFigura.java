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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String tipo = request.getParameter("tipo");

        try (PrintWriter out = response.getWriter()) {
            if (tipo == null || tipo.trim().isEmpty()) {
                out.print("{\"success\": false, \"error\": \"Debe seleccionar un tipo de figura.\"}");
                return;
            }
            tipo = tipo.toLowerCase();

            try {
                Figura figura = FactoryFigura.crearFigura(tipo);
                double area;
                String jsonResponse;
                String figuraTipoStr;

                if (tipo.equals("triangulo")) {
                    double base = Double.parseDouble(request.getParameter("base"));
                    double altura = Double.parseDouble(request.getParameter("altura"));
                    figura.establecerDimensiones(base, altura);
                    area = figura.calcularArea();
                    figuraTipoStr = "Triángulo";
                    jsonResponse = String.format("{\"success\": true, \"tipo\": \"%s\", \"area\": %.2f, \"dimensiones\": {\"base\": %.2f, \"altura\": %.2f}}",
                            figuraTipoStr, area, base, altura);
                } else if (tipo.equals("cuadrilatero")) {
                    double largo = Double.parseDouble(request.getParameter("largo"));
                    double ancho = Double.parseDouble(request.getParameter("ancho"));
                    figura.establecerDimensiones(largo, ancho);
                    area = figura.calcularArea();

                    if (largo == ancho) {
                        figuraTipoStr = "Cuadrado";
                    } else {
                        figuraTipoStr = "Rectángulo";
                    }
                    jsonResponse = String.format("{\"success\": true, \"tipo\": \"%s\", \"area\": %.2f, \"dimensiones\": {\"largo\": %.2f, \"ancho\": %.2f}}",
                            figuraTipoStr, area, largo, ancho);
                } else {
                     throw new IllegalArgumentException("Tipo de figura no soportado: " + tipo);
                }

                out.print(jsonResponse);

            } catch (NumberFormatException e) {
                out.print("{\"success\": false, \"error\": \"Los valores ingresados deben ser números válidos.\"}");
            } catch (IllegalArgumentException e) {
                out.print("{\"success\": false, \"error\": \"" + e.getMessage().replace("\"", "\\\"") + "\"}");
            } catch (Exception e) {
                out.print("{\"success\": false, \"error\": \"Error al procesar la solicitud: " + e.getMessage().replace("\"", "\\\"") + "\"}");
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
        return "Calculadora de áreas de figuras geométricas";
    }
}