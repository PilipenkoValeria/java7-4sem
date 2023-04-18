package ru.omsu;
import java.io.*;
import java.util.*;

public class DataService {
    public static void writeArrayToStream(int[] array, OutputStream outputStream) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            for (int i : array) {
                dataOutputStream.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readArrayFromStream(InputStream inputStream) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            int n = dataInputStream.available()/Integer.BYTES;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = dataInputStream.readInt();
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IOException("Not enough data");
    }

    public static void writeArrayToStreamWithSpace(int[] array, OutputStream outputStream) throws IOException {
        try  (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream))  {
            for (int i : array) {
                outputStreamWriter.write(i);
                outputStreamWriter.write(' ');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readArrayFromStreamWithSpace(InputStream inputStream) throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            int n = inputStream.available() / 2;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = inputStreamReader.read();
                inputStreamReader.skip(1);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IOException("Not enough data");
    }

    public static int[] readArrayRandomAccessFile(int pos, String filename) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw")) {
            int n = (int) randomAccessFile.length()/4 - pos;
            int[] array = new int[n];
            randomAccessFile.seek(pos * 4);
            for (int i = 0; i < n; i++) {
                array[i] = randomAccessFile.readInt();
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IOException("Not enough data");
    }
    public ArrayList<String> findFilesWithExtension(String extension, File catalog){
        ArrayList<String> listFilesWithExtension = new ArrayList<>();
        if(catalog.listFiles() == null){
            throw new IllegalArgumentException("Каталог пуст или не существует");
        }
        for(File file: catalog.listFiles()){
            if(file.isFile() && file.getName().endsWith(extension)){
                listFilesWithExtension.add(file.getName());
            }
        }
        return listFilesWithExtension;
    }
}
