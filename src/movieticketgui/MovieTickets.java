/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketgui;

/**
 *
 * @author okker
 */
/**
 * This class implements the iMovieTickets interface and provides methods
 * to calculate the total ticket price and validate movie ticket data.
 */
public class MovieTickets implements iMovieTickets {

    /**
     * Calculates the total ticket price including VAT.
     * @param numberOfTickets The number of tickets.
     * @param ticketPrice The price of a single ticket.
     * @return The total ticket price including VAT.
     */
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double totalPrice = numberOfTickets * ticketPrice;
        double vat = 0.14 * totalPrice; // 14% VAT calculation
        return totalPrice + vat;
    }


    /**
     * Validates the movie ticket data to ensure valid input.
     * @param movieTicketData The MovieTicketData object to validate.
     * @return True if the data is valid, false otherwise.
     */
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        return !movieTicketData.getMovieName().isEmpty() &&
                movieTicketData.getTicketPrice() > 0 &&
                movieTicketData.getNumberOfTickets() > 0;
    }
}
//---------------------...ooo000 END OF FILE 000ooo...------------------------//