# Movie Ticket Application

This is a simple Java application with a graphical user interface (GUI) for calculating the total price of movie tickets. It allows users to select a movie, enter the number of tickets, and the price per ticket. The application then calculates the total cost, including VAT, and generates a report.

## Features

* **GUI:** User-friendly interface built with Swing.
* **Movie Selection:** Choose from a list of available movies.
* **Ticket Input:** Enter the number of tickets and the price per ticket.
* **Total Cost Calculation:** Calculates the total cost of the tickets, including 14% VAT.
* **Report Generation:** Generates a report summarizing the movie, number of tickets, ticket price, and total cost.
* **File Saving:** Saves the generated report to a text file.
* **Validation:** Validates user input to ensure correct data is entered.
* **Unit Tests:** Includes JUnit tests to verify the functionality of the core logic.

## How to Run

1. **Clone the repository:** `git clone https://github.com/your-username/movie-ticket-app.git`
2. **Compile the code:**  You can use an IDE like IntelliJ IDEA or Eclipse to compile the Java files.
3. **Run the application:** Execute the `MovieTicketGUI.java` file to start the application.

## Code Structure

* **`MovieTicketGUI.java`:** Contains the main GUI class responsible for creating and managing the user interface.
* **`MovieTickets.java`:** Implements the `iMovieTickets` interface and provides methods for calculating the total ticket price and validating data.
* **`iMovieTickets.java`:** Defines the interface for movie ticket operations.
* **`MovieTicketData.java`:**  Represents the data associated with a movie ticket purchase.
* **`FileUtils.java`:** Provides a utility method for saving the report to a file.
* **`MovieTicketsTest.java`:**  Contains JUnit tests for the `MovieTickets` class.

## Usage

1. Select a movie from the drop-down list.
2. Enter the number of tickets you want to purchase.
3. Enter the price per ticket.
4. Click the "Process" button in the "Tools" menu.
5. The application will calculate the total cost and display a report in the text area.
6. The report will also be saved to a file named "report.txt".

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
