package ru.omsu;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.io.*;

import static org.junit.Assert.*;

public class DataServiceTest {
    @Test
    public void testWriteArrayToStream() throws IOException {
        int[] array = {1, 2, 3, 4, 5};
        byte[] expected = {0,0,0,1, 0,0,0,2, 0,0,0,3, 0,0,0,4, 0,0,0,5};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5* Integer.BYTES);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        DataService.writeArrayToStream(array,byteArrayOutputStream);
        //System.out.println(Arrays.toString(expected));
        //System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        assertArrayEquals(expected,byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testReadArrayFromStream() throws IOException {
        byte[] bytes = {0,0,0,1, 0,0,0,2, 0,0,0,3, 0,0,0,4, 0,0,0,5};
        int[] expected = {1,2,3,4,5};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int[] arr = DataService.readArrayFromStream(byteArrayInputStream);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testWriteArrayFromStreamWithSpace() throws IOException {
        int[] array = {1, 2, 3, 4, 5};
        byte[] expected = {1, 32, 2, 32, 3, 32, 4, 32, 5, 32};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5* Integer.BYTES);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        DataService.writeArrayToStreamWithSpace(array,byteArrayOutputStream);
        //System.out.println(Arrays.toString(expected));
        //System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        assertArrayEquals(expected,byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testReadArrayFromStreamWithSpace() throws IOException {
        byte[] bytes = {1, 32, 2, 32, 3, 32, 4, 32, 5, 32};
        int[] expected = {1,2,3,4,5};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int[] arr = DataService.readArrayFromStreamWithSpace(byteArrayInputStream);
        //System.out.println(Arrays.toString(expected));
        //System.out.println(Arrays.toString(arr));
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReadArrayRandomAccessFile() throws IOException {
        int[] arr = {1,2,3,4,5};
        int[] expected = {3,4,5};
        DataService.writeArrayToStream(arr,new FileOutputStream("test.txt"));
        int[] res = DataService.readArrayRandomAccessFile(2, "test.txt");
        //System.out.println(Arrays.toString(expected));
        //System.out.println(Arrays.toString(res));
        assertArrayEquals(expected,res);
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
