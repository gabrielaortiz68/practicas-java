/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gabri
 */
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Examen> baseDatosSimulada;
    private Examen vista;
    private int contadorId;

    public UsuarioController(ExamenView vista) {
        this.baseDatosSimulada = new ArrayList<>();
        this.vista = vista;
        this.contadorId = 1;
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje(
                        "Opción no válida. Intente de nuevo."
                    );
                    break;
            }

        } while (opcion != 5);
    }

    private void crearUsuario() {
        String nombre = vista.pedirTexto(
            "Ingrese el nombre del usuario: "
        );
        String email = vista.pedirTexto(
            "Ingrese el email del usuario: "
        );

        Examen nuevoUsuario =
            new Examen(contadorId++, nombre, email);

        baseDatosSimulada.add(nuevoUsuario);

        vista.mostrarMensaje(
            "Usuario creado exitosamente con ID: "
            + nuevoUsuario.getId()
        );
    }

    private void listarUsuarios() {
        vista.mostrarListaUsuarios(baseDatosSimulada);
    }

    private void actualizarUsuario() {
        int id = vista.pedirEntero(
            "Ingrese el ID del usuario a actualizar: "
        );

        Examen usuario = buscarPorId(id);

        if (usuario != null) {
            String nuevoNombre = vista.pedirTexto(
                "Ingrese el nuevo nombre: "
            );
            String nuevoEmail = vista.pedirTexto(
                "Ingrese el nuevo email: "
            );

            usuario.setNombre(nuevoNombre);
            usuario.setEmail(nuevoEmail);

            vista.mostrarMensaje(
                "Usuario actualizado correctamente."
            );
        } else {
            vista.mostrarMensaje(
                "Error: No se encontró ningún usuario con ese ID."
            );
        }
    }

    private void eliminarUsuario() {
        int id = vista.pedirEntero(
            "Ingrese el ID del usuario a eliminar: "
        );

        Examen usuario = buscarPorId(id);

        if (usuario != null) {
            baseDatosSimulada.remove(usuario);

            vista.mostrarMensaje(
                "Usuario eliminado correctamente."
            );
        } else {
            vista.mostrarMensaje(
                "Error: No se encontró ningún usuario con ese ID."
            );
        }
    }

    private Examen buscarPorId(int id) {
        for (Examen u : baseDatosSimulada) {
            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }
}