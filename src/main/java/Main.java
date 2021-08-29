import inputParameters.EnterDataFromConsole;
import messages.Messages;

public class Main implements Messages {

    public static void main(String[] args) {
        int programNumber = getNumber();
    }

    private static void chooseProgram(){
    }

    private static int getNumber() {
        while (true) {
            EnterDataFromConsole dataInput = new EnterDataFromConsole();
            try {
                int numberProgram = Integer.parseInt(dataInput.getParameters(ENTER_VALUES, PROGRAMS_LIST));
                return numberProgram;
            }catch (NumberFormatException nfe){
                System.out.println(ENTERED_AN_INCORRECT_VALUE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
