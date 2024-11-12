/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketgui;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author okker
 */
public class FileUtils {
    //save data to report file
    public static void saveReportToFile(String report) {
        try (FileWriter fileWriter = new FileWriter("report.txt")) {
            fileWriter.write(report);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving report to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
//---------------------...ooo000 END OF FILE 000ooo...------------------------//