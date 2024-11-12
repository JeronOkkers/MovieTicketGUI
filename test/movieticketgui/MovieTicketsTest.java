/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package movieticketgui;
import movieticketgui.MovieTicketData;
import movieticketgui.MovieTickets;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author okker
 */
public class MovieTicketsTest {
    
    public MovieTicketsTest() {
    }
    private final MovieTickets movieTickets = new MovieTickets();

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test: CalculateTotalTicketPrice_CalculatedSuccessfully
     * Purpose: Verifies that the calculate total ticket price method returns the correct price, including VAT.
     */
    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        MovieTickets movieTickets = new MovieTickets();
        int numberOfTickets = 5;
        double ticketPrice = 100.0;
        double expectedTotalPrice = 570.0; // 5 * 100 + 14% VAT
        double actualTotalPrice = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.001); 
    }

    @Test
    public void ValidateData_InvalidMovieName() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData movieTicketData = new MovieTicketData("", 5, 100.0);
        assertFalse(movieTickets.ValidateData(movieTicketData));
    }

    // Additional validation tests can be added for invalid number of tickets and ticket price
    @Test
    public void ValidateData_InvalidNumberOfTickets() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData movieTicketData = new MovieTicketData("Napoleon", 0, 100.0); 
        assertFalse(movieTickets.ValidateData(movieTicketData));
    }

    @Test
    public void ValidateData_InvalidTicketPrice() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData movieTicketData = new MovieTicketData("Napoleon", 5, -100.0); 
        assertFalse(movieTickets.ValidateData(movieTicketData));
    }
}
