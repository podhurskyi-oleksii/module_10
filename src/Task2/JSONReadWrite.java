package Task2;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class JSONReadWrite {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\workspace\\module_10\\src\\Task2\\file.txt");
        File user = new File("C:\\workspace\\module_10\\src\\Task2\\user.json");

        Scanner fin = new Scanner(new FileReader(file));
        FileWriter writer = new FileWriter(user);

        List<String> persons = new ArrayList<>();
        int i = 0;
        while (fin.hasNextLine()) {
            String[] arrayPerson = fin.nextLine().split(" ");
            if (i >= 1) {
                String name = arrayPerson[0];
                String ageString = arrayPerson[1];
                int age = Integer.parseInt(ageString.trim());
                User person = new User(name, age);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(person);
                persons.add(json);
            }
            i++;
        }
        writer.write(String.valueOf(persons));
        writer.flush();
    }
}
