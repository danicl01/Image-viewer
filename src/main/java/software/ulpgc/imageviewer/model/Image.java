package software.ulpgc.imageviewer.model;

public interface Image {
    String id();
    Image next();
    Image previous();
}
