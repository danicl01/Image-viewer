package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.ImageDisplay;
import software.ulpgc.imageviewer.command.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    public MainFrame() {
        this.commands = new HashMap<>();
        setTitle("IMAGE VIEWER");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(createImageDisplay());
        add(createBottomToolbar(), BorderLayout.SOUTH);
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }
    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    private Component createLeftButton(String leftArrow) {
        JButton button = new JButton(leftArrow);
        button.setBackground(new Color(173, 216, 230));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 22));

        button.addActionListener(e -> {
            commands.get("previous").execute();
        });
        button.setPreferredSize(new Dimension(80, 50));
        return button;
    }

    private Component createRightButton(String rightArrow) {
        JButton button = new JButton(rightArrow);
        button.setBackground(new Color(173, 216, 230));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 22));

        button.addActionListener(e -> {
            commands.get("previous").execute();
        });
        button.setPreferredSize(new Dimension(80, 50));
        return button;
    }

    private Component createBottomToolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(createLeftButton("◄"));
        panel.add(Box.createRigidArea(new Dimension(40, 0)));
        panel.add(createRightButton("►"));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        return panel;
    }
}
