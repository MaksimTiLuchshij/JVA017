package exercise1;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum StopWords{
    STOP,
    EXIT,
    END
}
public class StringWorker {
    private static final Scanner input = new Scanner(System.in);
    private List<String> inputStrings = new ArrayList<>();
    private String delimiter;
    private void enterData(){
        String inputString = "";
        while (true){
            System.out.println("Input a string: ");
            inputString = input.nextLine();

            if (!isUTF8(inputString)){
                System.out.println("Неверная кодировка, перезапустите программу и повторите");
            }

            if (isStopWord(inputString))
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

    private boolean isUTF8(String string){
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        String decodedStr = new String(bytes, StandardCharsets.UTF_8);
        if(string.equals(decodedStr))
            return true;
        else
            return false;
    }

    private boolean isStopWord(String string){
        var isStopWord = false;
        for(StopWords stopWord: StopWords.values()){
            if (string.equals(stopWord.name())){
                isStopWord = true;
                return isStopWord;
            }
        }
        return isStopWord;
    }

    public void runFunction(){
        enterData();
        chooseDelimiter();
        System.out.println(returnResult(getInputStrings(), getDelimiter()));
        input.close();
    }
}
