public class Controller {
    private String myFile;
    private FileReader myReader;
    private Parser myParser;
    private FileAssembler myFileAssembler;

    public Controller(String myFile){
        this.myFile = myFile;
        myFileAssembler = new FileAssembler(myFile);
        myParser = new Parser(myFileAssembler);
    }

    public void startController(){
        myReader = new FileReader(myFile, myFileAssembler, myParser);
        myReader.readFile();
        myFileAssembler.printArrayElements();
        myFileAssembler.writeChangesToFile();
    }
}
