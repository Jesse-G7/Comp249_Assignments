public class InvalidException extends Exception{

    private String message;

    public InvalidException(){
        super("Error:Input row cannot be parsed due to missing information.");
    }

    public InvalidException(String msg){
        message = msg;
    }

    public String getMessage(){
        return super.getMessage();
    }



}


