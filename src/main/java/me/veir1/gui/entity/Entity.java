package me.veir1.gui.entity;

public final class Entity {
    private final String rut;
    private final String nombreCompleto;
    private final String correo;
    private final char block;

    public Entity(String rut, String nombreCompleto, String correo, char block) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.block = block;
    }

    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public char getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "rut='" + rut + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
