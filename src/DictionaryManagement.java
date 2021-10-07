import java.io.*;
import java.util.*;



public class DictionaryManagement {

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số từ cần thêm:  ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ...");
            String engWord = sc.nextLine();
            String vieWord = sc.nextLine();
            Word word = new Word(engWord, vieWord);
            Dictionary.words.add(word);
        }
    }

    private static final String url = "src/dictionaries.txt";

    public static void insertFromFile() {

        try {
            File file = new File(url);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = "";
            while((line = reader.readLine()) != null){
                int tmp = line.indexOf("\t");
                String eng = line.substring(0, tmp);
                String vi = line.substring(tmp + 1, line.length());
                Word newWord = new Word(eng, vi);
                Dictionary.words.add(newWord);
            }
            reader.close();
        }
        catch (Exception e){
        }
    }

    public static String dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm:  ");
        String searchWord = sc.nextLine();
        Collections.sort(Dictionary.words);
        int index = Collections.binarySearch(Dictionary.words, new Word (searchWord, null));
        if (index >= 0) {
            return Dictionary.words.get(index).getWord_explain();
        } else {
            return "Not Found!";
        }
    }

    public static void addWord() {
        //check khi them tu thi tu do da ton tai hay chua
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ muốn thêm...");
        String engWord = sc.nextLine();
        String vieWord = sc.nextLine();
        Word word = new Word(engWord, vieWord);
        Dictionary.words.add(word);
    }

    public static void modifiWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ muốn sửa...");
        String engWord = sc.nextLine();
        Collections.sort(Dictionary.words);
        int index = Collections.binarySearch(Dictionary.words, new Word (engWord, null));
        if (index >= 0) {
            System.out.println("Sửa nghĩa thành...");
            String vieWord = sc.nextLine();
            Dictionary.words.get(index).setWord_explain(vieWord);
        } else {
            System.out.println("Not Found");
            return;
        }
    }

    public static void deleteWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ muốn xoá...");
        String engWord = sc.nextLine();
        Collections.sort(Dictionary.words);
        int index = Collections.binarySearch(Dictionary.words, new Word (engWord, null));
        if (index >= 0) {
            System.out.println("Đã xoá");
            Dictionary.words.remove(Dictionary.words.get(index));
        } else {
            System.out.println("Not Found");
            return;
        }
    }


}
