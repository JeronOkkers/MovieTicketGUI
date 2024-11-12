package movieticketgui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okker
 */
/**
 * This interface defines the methods for calculating total ticket price
 * and validating movie ticket data.
 */
public interface iMovieTickets {
    /**
     * Calculates the total ticket price.
     * @param numberOfTickets The number of tickets.
     * @param ticketPrice The price of a single ticket.
     * @return The total ticket price.
     */
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(MovieTicketData movieTicketData);
}
//---------------------...ooo000 END OF FILE 000ooo...------------------------//