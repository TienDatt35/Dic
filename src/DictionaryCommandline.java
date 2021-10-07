import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class DictionaryCommandline {
    public void showAllWords() {
        System.out.printf("%-10s%-20s%-20s\n", "NO", "English", "Vietnamese");
        for (int i = 0; i < Dictionary.words.size(); i++) {
            System.out.printf("%-10s%-20s%-20s\n", i+1, Dictionary.words.get(i).getWord_target(), Dictionary.words.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }


    public static void main(String[] args) {
        Dictionary tudien = new Dictionary();
        //DictionaryManagement.insertFromCommandline();

        DictionaryManagement.insertFromFile();

        DictionaryCommandline x = new DictionaryCommandline();
        x.showAllWords();

        DictionaryManagement.addWord();
        x.showAllWords();

        DictionaryManagement.modifiWord();
        x.showAllWords();

        DictionaryManagement.deleteWord();
        x.showAllWords();

        //System.out.println(DictionaryManagement.dictionaryLookup());


    }
}
