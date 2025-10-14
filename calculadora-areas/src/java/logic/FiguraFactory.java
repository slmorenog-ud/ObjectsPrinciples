/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author smore
 */

public class FiguraFactory {
    public static Figura crearFigura(String tipo) {
        switch(tipo.toLowerCase()) {
            case "triangulo":
                return new Triangulo();
            case "cuadrilatero":
                return new Cuadrilatero();
            default:
                throw new IllegalArgumentException("Tipo de figura no soportado: " + tipo);
        }
    }
}