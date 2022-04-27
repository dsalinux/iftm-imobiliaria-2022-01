package br.edu.iftm.imobiliaria.util;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danilo
 */
public class FileUtil {

    public static String creatTempFile(String name, byte[] content) {
        try {
            if (name == null || name.isEmpty()) {
                name = "tempFile" + new Date().getTime() + ".tmp";
            }
            File temp = File.createTempFile("file", "temp");
            File tempFile = new File(temp.getParent(), name);
            OutputStream os = new FileOutputStream(tempFile);
            os.write(content);
            os.flush();
            os.close();
            return tempFile.getAbsolutePath();
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static File getTempFile(String pathFileName) {
        File tempFile = new File(pathFileName);
        if (tempFile != null && tempFile.canRead() && tempFile.exists()) {
            return tempFile;
        }
        return null;
    }

    public static byte[] fileToByteArray(File file) {

        if (file == null || !file.exists()) {
            System.out.println("Arquivo informado não existe.");
            return null;
        }
        InputStream is = null;
        byte[] bytes = null;
        try {
            is = new FileInputStream(file);
            long length = file.length();
            bytes = new byte[(int) length];
            int offset = 0, n = 0;
            while (offset < bytes.length && (n = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += n;
            }
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bytes;
    }
}
