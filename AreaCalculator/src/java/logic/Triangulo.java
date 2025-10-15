/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author smore
 */
public class Triangulo implements Figura {
    private double base;
    private double altura;
    
    public Triangulo() {
        this.base = 0;
        this.altura = 0;
    }
    
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
    
    @Override
    public String getTipo() {
        return "Triángulo";
    }
    
    @Override
    public void establecerDimensiones(double... dimensiones) {
        if (dimensiones.length >= 2) {
            this.base = dimensiones[0];
            this.altura = dimensiones[1];
        }
    }
    
    @Override
    public double[] getDimensiones() {
        return new double[] {base, altura};
    }
    
    // Getters y setters específicos
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
}
