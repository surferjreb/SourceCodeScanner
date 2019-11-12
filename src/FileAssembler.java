import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileAssembler {

    private ArrayList<String> myElements;
    String myFile;
    private FileWriter myWriter;

    public FileAssembler(String myFile){
        myElements = new ArrayList<>();
        this.myFile = myFile;
    }

    public void checkString(String element){
        //checks for keyword value
        String temp="";

        if(element.equals("class") ||element.equals("public") || element.equals("static") ||
                element.equals("void") || element.equals("private")){
                    temp = element + " ";
        }
        else{
            temp = element;
        }

        addElementToList(temp);
    }//end checkString

    private void addElementToList(String temp){

        myElements.add(temp);
    }

    public void printArrayElements(){
        for(String value : myElements){
            System.out.print(value);
        }
    }

    public void writeChangesToFile(){
        try {
            FileWriter myWriter = new FileWriter(myFile, false);
            for(String value : myElements){
                myWriter.write(value);
            }
            myWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}//end class
