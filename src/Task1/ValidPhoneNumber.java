package Task1;

import java.io.*;

public class ValidPhoneNumber {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\workspace\\module_10\\src\\Task1\\file.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        String format1 = "\\(?[0-9]{3}\\) ?[0-9]{3}-?[0-9]{2}-?[0-9]{2}"; //format (xxx) xxx-xxxx
        String format2 = "[0-9]{3}-?[0-9]{3}-?[0-9]{4}"; //format xxx-xxx-xxxx
        while ((line = buffer.readLine()) != null) {
            if (line.matches(format1) || line.matches(format2))
                System.out.println(line);
        }
    }
}