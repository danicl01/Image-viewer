package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.model.Image;

public interface ImageDisplay {
    void show(Image image);
    Image image();
}
