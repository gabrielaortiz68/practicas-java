/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Contacto;


public class VentanaContacto extends JFrame {

    private JTextField txtNombre;
    private JTextField txtTelefono;
    private final JButton btn_Procesar;
    private JLabel lblResultado;

    public VentanaContacto() {
        setTitle("Registro de Contactos");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        btn_Procesar = new JButton("Procesar");
        lblResultado = new JLabel("Ingrese los datos");

        add(new JLabel("Nombre:"));add(txtNombre);

        add(new JLabel("Telefono:"));
        add(txtTelefono);

        add(btn_Procesar);
        add(new JLabel(""));

        add(new JLabel("Resultado:"));
        add(lblResultado);

        btn_Procesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText();
                String telefono = txtTelefono.getText();

                if (nombre.trim().isEmpty()
                        || telefono.trim().isEmpty()) {

                    lblResultado.setText("Complete los campos");

                } else {

                    Contacto contacto =
                            new Contacto(nombre, telefono);

                    lblResultado.setText("Nombre: " + contacto.getNombre() + " | Teléfono: " + contacto.getTelefono());
                }
            }
        });

      
    }
}
