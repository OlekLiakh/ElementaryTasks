package projects.happyTickets;

import inputParameters.DataInputFromConsole;

public class DataInput implements Messages {

    protected inputParameters.DataInput input = new DataInputFromConsole();

    public DataInput() {
    }

    public int[] getParameters() {
        System.out.println(ENTER_PARAMETERS);
        int firstTicketNumber = getParameter(ENTER_PARAMETERS_FIRST_TICKET);
        int secondTicketNumber = getParameter(ENTER_PARAMETERS_SECOND_TICKET);
        int[] mas = {firstTicketNumber, secondTicketNumber};
        return mas;
    }

    private int getParameter(String message) {
        while (true) {
            System.out.println(message);
            try {
                String enteredString = input.getParameters();
                int ticketNumber = Integer.parseInt(enteredString);
                if (ticketNumber < 0 || ticketNumber>=1000000) {
                    throw new NumberFormatException();
                }
                return ticketNumber;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_INPUT_PARAMETERS);
                System.out.println(INPUT_TEMPLATE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}