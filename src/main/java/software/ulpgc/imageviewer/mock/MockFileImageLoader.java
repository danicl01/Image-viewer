package software.ulpgc.imageviewer.mock;

import software.ulpgc.imageviewer.ImageLoader;
import software.ulpgc.imageviewer.model.Image;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

public class MockFileImageLoader implements ImageLoader {
    private final File[] files;
    private int currentIndex;
    private static final Set<String> imageExtensions = Set.of(".jpg", ".png");

    public MockFileImageLoader(File folder) {
        this.files = folder.listFiles(isImage());
        if (files == null) {
            throw new IllegalStateException("Error trying to obtain the list of files.");
        }
        this.currentIndex = 0;
    }

    private static FilenameFilter isImage() {
        return (dir, name) -> imageExtensions.stream().anyMatch(name::endsWith);
    }

    @Override
    public Image load() {
        if (files.length > 0) {
            return imageAt(currentIndex);
        } else {
            return null;
        }
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String id() {
                return files[i].getAbsolutePath();
            }

            @Override
            public Image next() {
                currentIndex = (currentIndex + 1) % files.length;
                return imageAt(currentIndex);
            }

            @Override
            public Image previous() {
                currentIndex = (currentIndex - 1 + files.length) % files.length;
                return imageAt(currentIndex);
            }
        };
    }
}
