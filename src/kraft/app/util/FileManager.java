package kraft.app.util;

import kraft.app.models.enums.Projects;

import java.io.File;

public class FileManager {
    private static FileManager instance;
    private File selectedFile;
    private Projects selectedProject;

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

    public Projects getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Projects selectedProject) {
        this.selectedProject = selectedProject;
    }
}
