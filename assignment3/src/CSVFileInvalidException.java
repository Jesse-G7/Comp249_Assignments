public class CSVFileInvalidException extends InvalidException{

    private String message;

    public CSVFileInvalidException(){
        super("Csv file is invalid due to missing filed.");
    }
    public CSVFileInvalidException(String msg){
        super(msg);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
