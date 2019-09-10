public class DukeException extends Exception{
    private String errorMessage;
    public DukeException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    /**
     * Returns the exception error message.
     * @return The exception error message.
     */
    public String toString(){
        return "\u2639 OOPS!!! " + this.errorMessage;
    }
}