/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Estudiantes
 */
public class Mamifero extends Animal {
    @Override
    public void crearAnimal(){
        this.tipo = "mamifero";
        this.nombre = "mami";
        this.comida = "come leche";
        this.habitat = "vive en la tierra";
    }
}
