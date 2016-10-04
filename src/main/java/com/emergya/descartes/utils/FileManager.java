package com.emergya.descartes.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * The Class FileManager.
 */
public class FileManager {

    private static Logger log = Logger.getLogger(FileManager.class);



    /**
     * Crea una copia de un fichero.
     *
     * @param sourceFilePath the source file path
     * @param destinationPath the destination path
     * @param fileName the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void copy(String sourceFilePath, String destinationPath,
            String fileName) throws IOException {
        File destinationPathObject = new File(destinationPath);
        File sourceFilePathObject = new File(sourceFilePath);
        if (destinationPathObject.isDirectory()) {
            File statusFileNameObject = new File(destinationPath + "/"
                    + fileName);
            FileUtils.copyFile(sourceFilePathObject, statusFileNameObject);

        }
    }

    /**
     * @param path
     * @return boolean
     */
    public static void deleteFilesInFolder(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()) {
                    files[i].delete();
                }
            }
        }
        
    }
}
