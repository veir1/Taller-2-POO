package me.veir1.gui.storage;

import me.veir1.gui.entity.ClassBlock;
import me.veir1.gui.entity.Entity;
import me.veir1.gui.storage.file.FileWriterProvider;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class PeopleStorage {
    private final FileWriterProvider fileWriterProvider;
    private final List<Entity> entities;

    private final static String WRITE_SUCCESSFUL = "Se ha añadido la entidad con el RUT %s. \nEl archivo de salida está ubicado en: %s.";
    private final static String PANIC_ERROR = "No se ha podido completar la acción solicitada: %s.\nCódigo de error: %s";

    public PeopleStorage(final String outputFile) {
        fileWriterProvider = new FileWriterProvider(outputFile);
        entities = new ArrayList<>();
    }

    public void addEntity(final Entity entity) {
        entities.add(entity);

        writeEntity(entity);
    }

    private void writeEntity(final Entity entity) {
        try {
            final BufferedWriter writer = fileWriterProvider.getWriter();
            try {
                final ClassBlock classBlock = new ClassBlock(entity.getBlock());
                writer.write(entity.getRut() + " " + entity.getNombreCompleto() + " " + entity.getCorreo() + " " + classBlock.getHorario());
                writer.newLine();
            } catch (final IOException exception) {
                JOptionPane.showMessageDialog(null, String.format(PANIC_ERROR, "PeopleStorage#writeEntities#forEach(Entity)", exception.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
                System.exit(1);
            }

            writer.flush();

            JOptionPane.showMessageDialog(null, String.format(WRITE_SUCCESSFUL, entity.getRut(), fileWriterProvider.getOutputAbsolutePath()), "Correcto", JOptionPane.INFORMATION_MESSAGE);
        } catch (final IOException exception) {
            JOptionPane.showMessageDialog(null, String.format(PANIC_ERROR, "PeopleStorage#writeEntities", exception.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
