package Task3;

import java.io.FileInputStream;
import java.io.IOException;
class WordCount {
    public String readFromFile(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            StringBuilder result = new StringBuilder();
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                result.append((char) buffer[i]);
            }
            return result.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public void frequencyOfWord(String text) {
        String[] words = text.split("\\s+");

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (!res.toString().contains(words[i])) {
                res.append(words[i]).append(" ");
            }
        }
        String[] resUniq = res.toString().split("\\s+");
        String[][] resul = new String[resUniq.length][2];
        for (int j = 0; j < resUniq.length; j++) {
            int count = 0;
            for (int g = 0; g < words.length; g++) {
                if (resUniq[j].equals(words[g])) {
                    count++;
                }
            }
            resul[j][1] = String.valueOf(count);
            resul[j][0] = resUniq[j];
        }

        for (int i = resul.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(resul[j][1]) < Integer.parseInt(resul[j + 1][1])) {
                    String[] tmp = resul[j];
                    resul[j] = resul[j + 1];
                    resul[j + 1] = tmp;
                }
            }
        }

        for (String[] a : resul) {
            System.out.println(a[0] + " " + a[1]);
        }
    }

    public static void main(String[] args) {
        WordCount test = new WordCount();
        String str = test.readFromFile("C:\\workspace\\module_10\\src\\Task3\\words.txt");
        test.frequencyOfWord(str);
    }
}
