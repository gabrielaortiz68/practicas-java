/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gabri
 */
public abstract class Persona {

    private String id;
    private String nombre;
    private Direccion direccion;

    public Persona(String id, String nombre, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    //Método abstracto creado para obligar a las subclases a implementar su calculo de sueldo
    public abstract double calcularSalario();
}

