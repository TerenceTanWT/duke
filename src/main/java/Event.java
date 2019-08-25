public class Event extends Task {

    private String at;

    public Event(String description, String by) {
        super(description);
        this.at = by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}