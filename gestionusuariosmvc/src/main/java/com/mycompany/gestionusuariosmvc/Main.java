/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author gabri
 */
package com.mycompany.gestionusuariosmvc;

public class Main {
    public static void main(String[] args) {
        UsuarioView vista = new UsuarioView();
        UsuarioController controlador = new UsuarioController(vista);

        controlador.iniciar();
    }
}
