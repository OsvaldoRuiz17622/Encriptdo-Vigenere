package EncriptadoVigenere;

public interface InterfazVista {

    void setControlador(Controlador c);

    public String getFileName();

    public String getText();

    public void setText(String s);

    static final String ABRIR = " Abrir archivo. ";
    static final String ENCRYPT = " Encriptar. ";
    static final String DECRYPT = " Decriptar. ";
    static final String GUARDAR = " Guardar texto. ";
}
