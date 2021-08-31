package projects.happyTickets;

import inputParameters.EnterDataFromConsole;

public class DataInput implements Messages {

    protected EnterDataFromConsole input = new EnterDataFromConsole();

    public DataInput() {
    }

    public int[] getParameters() {
        int firstTicketNumber = getParameter(ENTER_PARAMETERS_FIRST_TICKET);
        int secondTicketNumber = getParameter(ENTER_PARAMETERS_SECOND_TICKET);
        int[] mas = {firstTicketNumber, secondTicketNumber};
        return mas;
    }

    private int getParameter(String message) {
        while (true) {
            try {
                String enteredString = input.getParameters(message, INPUT_TEMPLATE);
                int ticketNumber = Integer.parseInt(enteredString);
                if (ticketNumber < 0 || ticketNumber>=1000000) {
                    throw new NumberFormatException();
                }
                return ticketNumber;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_INPUT_PARAMETERS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}