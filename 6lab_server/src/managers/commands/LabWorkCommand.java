package managers.commands;

import Data.LabWork;
import interfaces.CommandExecutor;

import java.util.Vector;

public interface LabWorkCommand extends CommandExecutor {
    void execute(Vector<LabWork> labWorks);
}
