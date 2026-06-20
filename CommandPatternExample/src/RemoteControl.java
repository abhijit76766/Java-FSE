public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            throw new IllegalStateException("No command assigned to the remote control.");
        }
        command.execute();
    }
}

