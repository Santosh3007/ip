package duke.command;

import duke.DukeException;
import duke.util.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class ExitCommand extends Command {

    public ExitCommand(Storage storage, Ui ui, TaskList taskList) {
        super(storage, ui, taskList);
    }

    @Override
    public void execute() throws DukeException {
        ui.bye();
        storage.saveTasks(taskList);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}