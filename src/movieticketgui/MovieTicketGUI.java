/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movieticketgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author okker
 */
/**
 * This class creates   
 the GUI for a movie ticket application.
 * It allows users to select a movie, enter the number of tickets,
 * and the ticket price, then calculates the total cost.
 */
public class MovieTicketGUI extends JFrame {

    private JComboBox<String> movieComboBox;
    private JTextField numberOfTicketsTextField;
    private JTextField ticketPriceTextField;
    private JTextArea ticketReportTextArea;
    private iMovieTickets movieTickets;

    
    /**
     * Constructor to initialize the GUI.
     */
    public MovieTicketGUI() {
        movieTickets = new MovieTickets();
        initUI();
    }

        /**
     * Initializes the UI components and sets up the frame.
     */
    private void initUI() {
        setTitle("Movie Tickets");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
        setJMenuBar(createMenuBar());
        
        setVisible(true);
    }

    /**
     * Creates and arranges the GUI components.
     */
    private void createComponents() {
        JLabel movieLabel = new JLabel("Movie:");
        movieComboBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        JLabel numberOfTicketsLabel = new JLabel("Number of Tickets:");
        numberOfTicketsTextField = new JTextField(10);
        JLabel ticketPriceLabel = new JLabel("Ticket Price:");
        ticketPriceTextField = new JTextField(10);
        JLabel ticketReportLabel = new JLabel("Ticket Report:");
        ticketReportTextArea = new JTextArea(10, 30);
        ticketReportTextArea.setEditable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the panel using the helper method
        addComponentsToPanel(panel, gbc, movieLabel, numberOfTicketsLabel, ticketPriceLabel, ticketReportLabel);

        JScrollPane scrollPane = new JScrollPane(ticketReportTextArea);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        add(panel);
    }
    /**
     * Helper method to add components to the panel with GridBagLayout.
     * @param panel The JPanel to add components to.
     * @param gbc The GridBagConstraints for layout.
     * @param labels An array of JLabels to add.
     */
    private void addComponentsToPanel(JPanel panel, GridBagConstraints gbc, JLabel... labels) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labels[0], gbc);
        gbc.gridx = 1;
        panel.add(movieComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labels[1], gbc);
        gbc.gridx = 1;
        panel.add(numberOfTicketsTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labels[2], gbc);
        gbc.gridx = 1;
        panel.add(ticketPriceTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(labels[3], gbc);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processMenuItem = new JMenuItem("Process");
        processMenuItem.addActionListener(e -> processTicketSales());
        toolsMenu.add(processMenuItem);

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(e -> clearFields());
        toolsMenu.add(clearMenuItem);

        menuBar.add(toolsMenu);

        return menuBar;
    }
    /**
     * Processes the ticket sales by validating input, calculating the total price,
     * generating a report, and saving it to a file.
     */
    private void processTicketSales() {
        try {
            // Create a MovieTicketData object with user input
            MovieTicketData movieTicketData = new MovieTicketData(
                    (String) movieComboBox.getSelectedItem(),
                    Integer.parseInt(numberOfTicketsTextField.getText()),
                    Double.parseDouble(ticketPriceTextField.getText())
            );

            if (movieTickets.ValidateData(movieTicketData)) {
                double totalTicketPrice = movieTickets.CalculateTotalTicketPrice(movieTicketData.getNumberOfTickets(), movieTicketData.getTicketPrice());
                String report = generateReport(movieTicketData, totalTicketPrice);
                ticketReportTextArea.setText(report);

                FileUtils.saveReportToFile(report);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input data. Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for tickets and price.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Generates a report string with movie details and total price.
     * @param movieTicketData The MovieTicketData object.
     * @param totalTicketPrice The calculated total ticket price.
     * @return The formatted report string.
     */
    private String generateReport(MovieTicketData movieTicketData, double totalTicketPrice) {
        return String.format("MOVIE NAME: %s\nMOVIE TICKET PRICE: R %.2f\nNUMBER OF TICKETS: %d\nTOTAL TICKET PRICE: R %.2f",
                movieTicketData.getMovieName(), movieTicketData.getTicketPrice(), movieTicketData.getNumberOfTickets(), totalTicketPrice);
    }

    /**
     * Clears all input fields and the report area.
     */
    private void clearFields() {
        movieComboBox.setSelectedIndex(0);
        numberOfTicketsTextField.setText("");
        ticketPriceTextField.setText("");
        ticketReportTextArea.setText("");
    }

    public static void main(String[] args) {
        new MovieTicketGUI();
    }
}
//---------------------...ooo000 END OF FILE 000ooo...------------------------//
