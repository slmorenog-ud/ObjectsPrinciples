package logic;

public interface Figura {
    double calcularArea();
    String getTipo();
    void establecerDimensiones(double... dimensiones);
    double[] getDimensiones();
}