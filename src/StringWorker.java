import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringWorker {
    private static final Scanner input = new Scanner(System.in);
    private static final String EXIT = "exit";
    private List<String> inputStrings = new ArrayList<>();
    private String delimiter;
    private void enterData(){
        String inputString = "";
        while (true){
            System.out.println("Input a string: ");
            inputString = input.nextLine();
            if (inputString.equals(EXIT))
                break;
            inputStrings.add(inputString);
        }
    }

    private void chooseDelimiter(){
        System.out.println("Input a delimiter");
        delimiter = input.nextLine();
    }

    private String returnResult(List<String> inputStrings, String delimiter){
        String result = "";
        for(String str: inputStrings){
            result += str;
            if (inputStrings.indexOf(str) != inputStrings.size() - 1)
                result += delimiter;
        }
        return result;
    }

    private List<String> getInputStrings() {
        return inputStrings;
    }

    private String getDelimiter() {
        return delimiter;
    }

    public void runFunction(){
        enterData();
        chooseDelimiter();
        System.out.println(returnResult(getInputStrings(), getDelimiter()));
        input.close();
    }
}
