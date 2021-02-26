package kraft.app.util;

import java.io.File;

public class FileManager {
    private static FileManager instance;
    private File selectedFile;

    private FileManager() {

    }

    public static FileManager getInstance() {
        if (instance == null)
            instance = new FileManager();
        return instance;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public File getSelectedFile() {
        return selectedFile;
    }
}
