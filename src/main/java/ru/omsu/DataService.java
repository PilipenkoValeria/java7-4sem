package ru.omsu;
import java.io.*;
import java.util.*;

public class DataService {
    //1. Записать массив целых чисел в двоичный поток
    public static void writeArrayToStream(OutputStream outputStream, int[] array) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            for (int i : array) {
                dataOutputStream.writeInt(i);
            }
        }
    }

    //1. Прочитать массив целых чисел из двоичного потока
    public static void readArrayFromStream(InputStream inputStream, int[] array) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(inputStream)) {
            for (int i = 0; i < array.length; i++) {
                array[i] = dataInputStream.readInt();
            }
        }
    }

    //2. Cимвольные потоки. В потоке числа должны разделяться пробелами
    public static void writeArrayToStreamWithSpace(OutputStream outputStream, int[] array) throws IOException {
        try  (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream))  {
            for (int i=0; i< array.length;i++){
                outputStreamWriter.write(String.valueOf(array[i]));
                if(i< array.length-1){
                    outputStreamWriter.write(" ");
                }
            }
        }
    }

    public static void readArrayFromStreamWithSpace(InputStream inputStream, int[] array) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){

            String[] sArr = reader.readLine().split(" ");
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(sArr[i]);
            }
        }
    }

    //3. Используя класс RandomAccessFile, прочитайте массив целых чисел, начиная с заданной позиции
    public static void readArrayRandomAccessFile(String filename, int[] array, int pos) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw")) {
           randomAccessFile.seek(pos*Integer.BYTES);
            for (int i = 0; i < array.length; i++) {
                array[i] = randomAccessFile.readInt();
            }
        }
    }
    //4. Используя класс File, получите список всех файлов с заданным расширением в заданном каталоге
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
