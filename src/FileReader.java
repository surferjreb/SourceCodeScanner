import java.io.File;
import java.util.Scanner;

public class FileReader {

    private String myFile;

    public FileReader(String myFile){
        System.out.println("File Reader Created");
        this.myFile = myFile;

    }

    public void readFile(){
        try {
            File file = new File(myFile);
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                readEachLine(input);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//end read file
    //-----------------------------------------------
    private void readEachLine(Scanner file){
        Parser myParser;
        //Scanner myFile = new Scanner(file.nextLine()).useDelimiter("\\s");
        String[] lineElements = file.nextLine().split("\\r");

        //int count = 0;
        for(String value : lineElements){
            //  System.out.println(count +" : "+ value);
            //  count++;
            if(value.isEmpty()){
                break;
            }
            else {
                for(int i = 0; i < value.length(); i++){
                    if (value.charAt(i) == '/' || value.charAt(i) == '*') {
                        value = "";
                    }
                }
                myParser  = new Parser(value);
                myParser.runParse();

            }


        }

    }
}
