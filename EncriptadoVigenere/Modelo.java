package EncriptadoVigenere;

import java.io.BufferedReader;             //LIBRERIAS UTILIZADAS
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class Modelo {

    private String contenido;
    private String fileName;
    final char shiftup = (char) 3;
    final char shiftdown = (char) 1;

    public void setContenido(String texto) {
        contenido = texto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setFileName(String nombre) {
        fileName = nombre;
    }

    public String encriptar() {
        String ctext = "";
        for (String linea : contenido.split("\n")) {
            StringBuilder cadena = new StringBuilder();
            for (char c : linea.toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftup;
                }
                cadena.append(c);
            }

            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = cadena.reverse().toString();

            int h = shifttext.length() / 2;
            for (char c : shifttext.substring(h,
                    shifttext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c -= shiftdown;
                }
                shift_cadena.append(c);
            }
            ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + '\n';
        }
        contenido = ctext;
        return ctext;
    }

    public String desencriptar() {
        String texto = "";
        for (String ctext : contenido.split("\n")) {
            int h = ctext.length() / 2;
            StringBuilder shift_cadena = new StringBuilder(ctext.substring(0, h));

            for (char c : ctext.substring(h, ctext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftdown;
                }
                shift_cadena.append(c);
            }

            String shifttext = shift_cadena.reverse().toString();
            StringBuilder cadena = new StringBuilder();

            for (char c : shifttext.toCharArray()) {
                if (Character.isLetter(c - 3)) {
                    c -= shiftup;
                }
                cadena.append(c);
            }
            texto = texto + cadena.toString() + '\n';
        }
        contenido = texto;
        return texto;
    }

    public String read() {
        String cad;
        String content = "";
        File file = new File(fileName);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((cad = b.readLine()) != null) {
                    content = content + cad + '\n';
                }
                b.close();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error al abrir archivo .");
        } catch (IOException ioException) {
            System.err.println(" Error de lectura de archivo .");
            
        }
        contenido = content;
        return content;
    }

    public void write() {
        try {
            File archivo = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    archivo));
            bw.write(contenido);
            bw.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error opening file .");
        } catch (IOException ioException) {
            System.err.println(" Error reading file .");
        }
    }
}
