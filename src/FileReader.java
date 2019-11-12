import java.io.File;
import java.util.Scanner;

public class FileReader {

    private String myFile;
    private Parser myParser;
    private FileAssembler myFileAssembler;

    public FileReader(String myFile, FileAssembler myFileAssembler, Parser myParser){
        this.myFileAssembler = myFileAssembler;
        this.myParser = myParser;
        this.myFile = myFile;

    }

    public void readFile(){
        try {
            File file = new File(myFile);
            Scanner input = new Scanner(file);

            //reads each line
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
        String[] lineElements = file.nextLine().split("\\r");

        for(String value : lineElements){

            if(value.isEmpty()){
                break;
            }
            else {
                for(int i = 0; i < value.length(); i++){
                    if (value.charAt(i) == '/' || value.charAt(i) == '*') {
                        value = "";
                        break;
                    }
                }

                myParser.runParse(value);
            }//end if else

        }//end foreach

    }//end readEachLine

}//end class
