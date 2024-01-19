package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.command.NextCommand;
import software.ulpgc.imageviewer.command.PreviousCommand;
import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.mock.MockFileImageLoader;

import java.io.File;

public class Main {
    private static final String root = "C:/Users/Usuario/Pictures";
    private static final String COMMAND_PREVIOUS = "previous";
    private static final String COMMAND_NEXT = "next";


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        try {
            Image image = new MockFileImageLoader(new File(root)).load();
            frame.imageDisplay().show(image);
            frame.add(COMMAND_PREVIOUS, new PreviousCommand(frame.imageDisplay()));
            frame.add(COMMAND_NEXT, new NextCommand(frame.imageDisplay()));
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error loading image: " + e);
        }
    }
}

