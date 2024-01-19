package software.ulpgc.imageviewer.command;

import software.ulpgc.imageviewer.ImageDisplay;

public class PreviousCommand implements Command {
    private final ImageDisplay imageDisplay;

    public PreviousCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().previous());
    }
}
