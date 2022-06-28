package me.veir1.gui.storage.file;

import javax.swing.*;
import java.io.*;

public final class FileWriterProvider {
    private BufferedReader reader;
    private BufferedWriter writer;
    private final String outputPath;
    private String outputAbsolutePath;
    private final static String PANIC_ERROR = "No se ha podido completar la acción solicitada: %s.\nCódigo de error: %s";

    public FileWriterProvider(final String outputFile) {
        outputPath = outputFile;

        makeWriter(outputPath);
    }

    private void makeWriter(final String outputFile) {
        final String path = System.getProperty("user.dir") + System.getProperty("file.separator") + outputFile;
        outputAbsolutePath = path; // Guardo la ruta absoluta de salida.
        try {
            writer = new BufferedWriter(new FileWriter(path));
        } catch (final IOException exception) {
            JOptionPane.showMessageDialog(null, String.format(PANIC_ERROR, "FileReaderWriterProvider#makeWriter", exception.getMessage()), "Error", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
            System.exit(1);
        }
    }

    public BufferedWriter getWriter() {
        if (writer == null) {
            makeWriter(outputPath);
        }
        return writer;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getOutputAbsolutePath() {
        return outputAbsolutePath;
    }
}
