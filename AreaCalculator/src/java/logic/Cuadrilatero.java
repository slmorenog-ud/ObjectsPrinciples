/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author smore
 */
public class Cuadrilatero implements Figura {
    private double largo;
    private double ancho;
    
    public Cuadrilatero() {
        this.largo = 0;
        this.ancho = 0;
    }
    
    @Override
    public double calcularArea() {
        return largo * ancho;
    }
    
    @Override
    public String getTipo() {
        return "Cuadrilatero";
    }
    
    @Override
    public void establecerDimensiones(double... dimensiones) {
        if (dimensiones.length >= 2) {
            this.largo = dimensiones[0];
            this.ancho = dimensiones[1];
        }
    }
    
    @Override
    public double[] getDimensiones() {
        return new double[] {largo, ancho};
    }
    
    // Getters y setters específicos
    public double getLargo() {
        return largo;
    }
    
    public void setLargo(double largo) {
        this.largo = largo;
    }
    
    public double getAncho() {
        return ancho;
    }
    
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
}