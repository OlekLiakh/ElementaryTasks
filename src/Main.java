import inputParameters.DataInput;
import inputParameters.DataInputFromConsole;
import messages.Messages;

public class Main implements Messages {

    public static void main(String[] args) {
        System.out.println(CHOOSE_PROGRAM);
        System.out.println(PROGRAMS_LIST);
        int programNumber = getNumber();

    }

    private static void chooseProgram(){

    }

    private static int getNumber() {
        while (true) {
            DataInput dataInput = new DataInputFromConsole();
            try {
                int numberProgram = Integer.parseInt(dataInput.getParameters());
                return numberProgram;
            }catch (NumberFormatException nfe){
                System.out.println(ENTERED_AN_INCORRECT_VALUE);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
