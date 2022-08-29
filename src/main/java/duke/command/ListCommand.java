package duke.command;

import duke.util.TaskList;
import duke.util.Storage;
import duke.util.Ui;

public class ListCommand extends Command {

    public ListCommand(Storage storage, Ui ui, TaskList taskList) {
        super(storage, ui, taskList);
    }

    @Override
    public void execute() {
        taskList.displayList();
    }
}