package EncriptadoVigenere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Controlador implements ActionListener {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        vista.setControlador(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) { //Se manejan las diferences acciones.
        switch (event.getActionCommand()) {
            case InterfazVista.ABRIR:
                modelo.setFileName(vista.getFileName());
                vista.setText(modelo.read());
                break;
            case InterfazVista.ENCRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.encriptar());
                break;
            case InterfazVista.DECRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.desencriptar());
                break;
            case InterfazVista.GUARDAR:
                modelo.setFileName(vista.getFileName());
                modelo.setContenido(vista.getText());
                modelo.write();
                break;
            default:
                System.err.println(" Comando no reconocido ");
                break;
        }
    }

    public void arrancar() { // Comienza la visualizacion
        vista.setLocationRelativeTo(null); // centra la ventana con respecto a la pantalla
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(600, 300);
        vista.setVisible(true);
    }
}
