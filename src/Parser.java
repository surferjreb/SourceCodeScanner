public class Parser {


    private String parseString;
    private FileAssembler myAssembler;

    public Parser(FileAssembler myAssembler){
        this.myAssembler = myAssembler;

    }

    public void runParse(String element){
        //insert string in char array
        //parse some values
        String newElement;
        char[] elementLetters = element.toCharArray();
        //break down to char array and remove all spaces and
        //copy into new array
        newElement = beginParse(elementLetters);
        checkString(newElement);
    }

    private String beginParse(char[] letters){
        String temp = "";
        int count=0;
        try{
            for(char letter : letters){
                if(letter != ' '){
                    temp += letter;

                }
            }
            return temp;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }//end begin parse

    private void checkString(String newElement){
        if(!newElement.isEmpty()){
            myAssembler.checkString(newElement);
        }
    }
}
