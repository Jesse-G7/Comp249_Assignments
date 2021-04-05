public class CSVDataMissing extends InvalidException{
    private String message;

    public CSVDataMissing(){
        super("Csv file is invalid due to missing data.");
    }
    public CSVDataMissing(String msg){
        super(msg);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
