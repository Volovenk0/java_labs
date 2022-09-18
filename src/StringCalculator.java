import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    private int tryParseInt(String string){
        try{
            try {
                return Integer.parseInt(string);
            }
            catch(NumberFormatException ex){
                throw new NumberFormatException("Attempt to convert " + string + " to a number.");
            }
        }
        catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    private List<String> mySplit(String text, List<String> splitSymbols){
        List<String> result = new ArrayList<>();
        result.add("");
        int index = 0;
        for(int i = 0; i < text.length(); i++){
            if(splitSymbols.contains(Character.toString(text.charAt(i)))){
                result.add("");
                index++;
            }
            else{
                result.set(index, result.get(index) + text.charAt(i));
            }
        }


        for(int i = result.size() - 1; i >= 0; i--){
            if(result.get(i).equals("")) result.remove(i);
        }

        return result;
    }

    public int add(String numbers)
    {
        if(numbers.contains("\\n"))  numbers = numbers.replace("\\n", "\n");
        List<String> delimiters = new ArrayList<>();
        int delimiterIndex = 0;
        int index = 0;
        if(numbers.startsWith("//")){
            for(int i = 2; i < numbers.length(); i++){
                if(numbers.charAt(i) == '\n'){
                    index = i + 1;
                    break;
                }
                else if(numbers.charAt(i) == '[') {
                    delimiters.add("");
                    continue;
                }
                else if(numbers.charAt(i) != ']'){
                    delimiters.set(delimiterIndex, delimiters.get(delimiterIndex) + numbers.charAt(i));
                }
                else delimiterIndex++;
            }
        }
        delimiters.add(",");
        delimiters.add("\n");


        String finalNumbers = numbers.substring(index, numbers.length());

        List<String> splitNumbers = mySplit(finalNumbers, delimiters);

        int sum = 0;
        for(int i = 0; i < splitNumbers.size(); i++){
            int tempNumber = tryParseInt(splitNumbers.get(i));
            if(tempNumber < 0){
                try{
                    throw new Exception("Negative numbers are not allowed: " + tempNumber + ".");
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            else if(tempNumber <= 1000){
                sum += tempNumber;
            }

        }

        return sum;
    }
}
