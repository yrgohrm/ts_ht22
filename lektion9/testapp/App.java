import java.io.*;
import java.nio.file.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> data = readStuff();
        List<String> reversed = reverseAll(data);
        List<String> uppercase = ucase(reversed);
        writeSorted(uppercase);
    }

    private static void writeSorted(List<String> data) throws IOException {
        Collections.sort(data);
        Files.writeString(Path.of("out.txt"), data.toString());
    }

    private static List<String> reverseAll(List<String> data) {
        var data2 = new ArrayList<String>();
        for (String str : data) {
            data2.add(new StringBuilder(str).reverse().toString());
        }
        return data2;
    }

    private static List<String> ucase(List<String> data) {
        var data2 = new ArrayList<String>();
        for (String str : data) {
            data2.add(str.toUpperCase());
        }
        return data2;
    }


    
    private static List<String> readStuff() throws IOException {
        var data = new ArrayList<String>(30000);
        try (BufferedReader r = Files.newBufferedReader(Path.of("wop.txt"))) {
            String line;
            while ((line = r.readLine()) != null) {
                data.add(line);
            }
            return data;
        }
    }
}