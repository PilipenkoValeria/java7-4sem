package ru.omsu;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.io.*;
import static org.junit.Assert.*;

public class DataServiceTest {
    @Test
    public void testWriteAndReadArrayToStream() throws IOException {
        int[] arr1 = { 10, -12479, 2, 8500 };
        try(FileOutputStream file1 = new FileOutputStream("test.txt")) {
            DataService.writeArrayToStream(file1,arr1);
        }
        int[] arr2 = new int[4];
        try(FileInputStream file2 = new FileInputStream("test.txt")) {
            DataService.readArrayFromStream(file2, arr2);
        }
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testWriteAndReadArrayFromStreamWithSpace() throws IOException {
        int[] arr1 = { 5, 2, 25, 850000 };
        try(FileOutputStream file1 = new FileOutputStream("test1.txt")) {
            DataService.writeArrayToStreamWithSpace(file1,arr1);
        }
        int[] arr2 = new int[4];
        try(FileInputStream file2 = new FileInputStream("test1.txt")) {
            DataService.readArrayFromStreamWithSpace(file2, arr2);
        }
        assertArrayEquals(arr1, arr2);

    }


    @Test
    public void testReadArrayRandomAccessFile() throws IOException {
        int[] arr1 = { 1, 2, 3, 7, 99, 66, 780000 };
        try(FileOutputStream file1 = new FileOutputStream("test2.txt")) {
            DataService.writeArrayToStream(file1, arr1);
        }
        int[] arr2 = new int[4];
        DataService.readArrayRandomAccessFile("test2.txt", arr2, 3);
        assertArrayEquals(new int[] { 7, 99, 66, 780000 }, arr2);
    }

    @Test
    public void testFindFilesWithExtension(){
        ArrayList<String> expected = new ArrayList<>();
        DataService dataService = new DataService();
        Collections.addAll(expected, "DataService.java", "Flat.java", "House.java", "HouseService.java", "Person.java");
        ArrayList<String> actual = dataService.findFilesWithExtension("java", new File(
                "C:\\Work\\ru\\omsu\\Java\\java7-4sem\\src\\main\\java\\ru\\omsu"));
        Assert.assertEquals(expected, actual);
    }
}
