package me.veir1.gui.entity;

public final class ClassBlock {
    private String horario;

    public ClassBlock(final char block) {
        if (block == 'A') this.horario = "4:00 - 4:40";
        if (block == 'B') this.horario = "4:40 - 5:20";
    }

    public String getHorario() {
        return horario;
    }
}
