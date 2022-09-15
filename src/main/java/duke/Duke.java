package duke;

import duke.command.Command;
import duke.util.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;

/**
 * Main class for duke.
 */
public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList taskList;
    private Parser parser;
    private Command command;

    /**
     * Constructs a Duke object.
     */
    public Duke() {
        storage = new Storage("data/duke.txt");
        ui = new Ui();
        taskList = new TaskList();
        storage.loadTasks(taskList);
        parser = new Parser(storage, ui, taskList);
    }

    /**
     * Returns string message to greet user.
     * @return Greeting string.
     */
    public String greet() {
        return ui.greet();
    }

    public String getResponse(String input) {
        try {
            command = parser.parse(input);
            return command.execute();
        } catch (NumberFormatException e) {
            return ui.showError("Please Enter a valid task number!");
        } catch (IllegalArgumentException e) {
            return ui.showError("I'm sorry but I don't know what that means.");
        } catch (DukeException e) {
            return ui.showError(e);
        }
    }
}
