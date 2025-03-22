import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SistemaGestionGanadera extends JFrame {

    public SistemaGestionGanadera() {
        setTitle("Sistema de Gestión de Finca Ganadera");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un contenedor con pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Módulo: Registro de Animales
        tabbedPane.addTab("Registro de Animales", crearPanelRegistroAnimales());

        // Módulo: Alimentación
        tabbedPane.addTab("Alimentación", crearPanelAlimentacion());

        // Módulo: Vacunación
        tabbedPane.addTab("Vacunación", crearPanelVacunacion());

        // Módulo: Producción de Leche
        tabbedPane.addTab("Producción de Leche", crearPanelProduccionLeche());

        // Añadir el contenedor de pestañas al marco principal
        add(tabbedPane);
    }

    private JPanel crearPanelRegistroAnimales() {
        JPanel panel = new JPanel(new BorderLayout());

        // Componentes del formulario
        JPanel formulario = new JPanel(new GridLayout(5, 2));
        formulario.add(new JLabel("Nombre del Animal:"));
        JTextField nombreField = new JTextField();
        formulario.add(nombreField);
        formulario.add(new JLabel("Raza:"));
        JTextField razaField = new JTextField();
        formulario.add(razaField);
        formulario.add(new JLabel("Fecha de Nacimiento:"));
        JTextField fechaField = new JTextField();
        formulario.add(fechaField);
        formulario.add(new JLabel("Estado de Salud:"));
        JTextField saludField = new JTextField();
        formulario.add(saludField);

        // Botón para registrar el animal
        JButton registrarButton = new JButton("Registrar");
        formulario.add(registrarButton);

        panel.add(formulario, BorderLayout.NORTH);

        // Tabla para mostrar animales registrados
        JTable tabla = new JTable(new DefaultTableModel(new String[]{"Nombre", "Raza", "Fecha", "Salud"}, 0));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        registrarButton.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{nombreField.getText(), razaField.getText(), fechaField.getText(), saludField.getText()});
            nombreField.setText("");
            razaField.setText("");
            fechaField.setText("");
            saludField.setText("");
        });

        return panel;
    }

    private JPanel crearPanelAlimentacion() {
        JPanel panel = new JPanel(new BorderLayout());

        // Descripción del módulo
        panel.add(new JLabel("Registro de Alimentación por Lotes"), BorderLayout.NORTH);

        // Tabla para registrar consumos
        JTable tabla = new JTable(new DefaultTableModel(new String[]{"Lote", "Tipo de Alimento", "Cantidad"}, 0));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelVacunacion() {
        JPanel panel = new JPanel(new BorderLayout());

        // Componentes del formulario
        JPanel formulario = new JPanel(new GridLayout(4, 2));
        formulario.add(new JLabel("Animal ID:"));
        JTextField animalIdField = new JTextField();
        formulario.add(animalIdField);
        formulario.add(new JLabel("Tipo de Vacuna:"));
        JTextField vacunaField = new JTextField();
        formulario.add(vacunaField);
        formulario.add(new JLabel("Fecha:"));
        JTextField fechaField = new JTextField();
        formulario.add(fechaField);

        JButton registrarButton = new JButton("Registrar Vacuna");
        formulario.add(registrarButton);

        panel.add(formulario, BorderLayout.NORTH);

        JTable tabla = new JTable(new DefaultTableModel(new String[]{"Animal ID", "Vacuna", "Fecha"}, 0));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        registrarButton.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{animalIdField.getText(), vacunaField.getText(), fechaField.getText()});
            animalIdField.setText("");
            vacunaField.setText("");
            fechaField.setText("");
        });

        return panel;
    }

    private JPanel crearPanelProduccionLeche() {
        JPanel panel = new JPanel(new BorderLayout());

        // Componentes del formulario
        JPanel formulario = new JPanel(new GridLayout(4, 2));
        formulario.add(new JLabel("Fecha:"));
        JTextField fechaField = new JTextField();
        formulario.add(fechaField);
        formulario.add(new JLabel("Cantidad (L):"));
        JTextField cantidadField = new JTextField();
        formulario.add(cantidadField);
        formulario.add(new JLabel("Animal ID:"));
        JTextField animalIdField = new JTextField();
        formulario.add(animalIdField);

        // Botón para registrar la producción de leche
        JButton registrarButton = new JButton("Registrar Producción");
        formulario.add(registrarButton);

        panel.add(formulario, BorderLayout.NORTH);

        // Tabla para mostrar la producción de leche registrada
        JTable tabla = new JTable(new DefaultTableModel(new String[]{"Fecha", "Cantidad (L)", "Animal ID"}, 0));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        registrarButton.addActionListener(e -> {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{fechaField.getText(), cantidadField.getText(), animalIdField.getText()});
            fechaField.setText("");
            cantidadField.setText("");
            animalIdField.setText("");
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaGestionGanadera frame = new SistemaGestionGanadera();
            frame.setVisible(true);
        });
    }
}
