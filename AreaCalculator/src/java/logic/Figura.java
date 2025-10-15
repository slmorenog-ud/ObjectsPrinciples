/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author smore
 */
public interface Figura {
    double calcularArea();
    String getTipo();
    void establecerDimensiones(double... dimensiones);
    double[] getDimensiones();
}