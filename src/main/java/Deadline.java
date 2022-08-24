public class Deadline extends Task {
    private String deadline;

    /**
     * Constructor to create new Deadline
     * 
     * @param description Description of deadline you want to create
     * @param deadline    Deadline of the task
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline.trim();
    }

    /**
     * Constructor to create new Deadline with isDone
     * 
     * @param description Description of deadline you want to create
     * @param deadline    Deadline of the task
     * @param isDone      Whether the task is done or not
     */
    public Deadline(String description, String deadline, boolean isDone) {
        super(description, isDone);
        this.deadline = deadline.trim();
    }

    /**
     * Factory method to create new Deadline
     * 
     * @param input String including task description and deadline specified after
     *              /by
     * @return New Deadline
     * @throws DukeException if deadline is not specified using /by
     */
    public static Deadline createDeadline(String input) throws DukeException {
        if (input.indexOf("/by ") == -1) {
            throw new DukeException("Please enter a valid deadline using the /by flag.");
        }
        if (input.indexOf("/completed ") == -1) {
            String description = input.split("/by ")[0];
            String deadline = input.split("/by ")[1];
            return new Deadline(description, deadline);
        } else {
            boolean isDone = Boolean.parseBoolean(input.split("/completed ")[1]);
            input = input.split("/completed ")[0];
            String description = input.split("/by ")[0];
            String deadline = input.split("/by ")[1];
            return new Deadline(description, deadline, isDone);
        }
    }

    @Override
    public String getFileString() {
        return "deadline " + this.description + " /by " + this.deadline + " /completed " + this.isDone;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline + ")";
    }
}
