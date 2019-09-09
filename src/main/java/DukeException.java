package duke;

public class DukeException extends Exception{
    private String errorMessage;
    public DukeException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String toString(){
        return "\u2639 OOPS!!! " + this.errorMessage;
    }
}