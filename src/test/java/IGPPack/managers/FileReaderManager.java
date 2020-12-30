package IGPPack.managers;

import IGPPack.Utilities.ReadConfig;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    ReadConfig readConfig;

    private FileReaderManager(){

    }

    public static FileReaderManager getInstance(){

        return fileReaderManager;
    }

    public ReadConfig getConfigReader(){

        return (readConfig==null) ? new ReadConfig(): readConfig;
    }
}
