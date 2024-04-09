package klerer.dictionary;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishDictionary {

    private Map<String, List<String>> dictionary;

    public EnglishDictionary() {
        dictionary = new HashMap<>();

        // gets the file from the resources directory
        InputStream in = EnglishDictionary.class.getResourceAsStream("/englishDictionary.csv");

        if (in == null) {
            System.err.println("Failed to open input stream for 'englishDictionary.csv'");
            return;
        }

        try (CSVReader reader = new CSVReader(new InputStreamReader(in))) {
            String[] record;
            while ((record = reader.readNext()) != null) {
                // record[0] contains the word, record[1] contains the definition
                String word = record[0].toLowerCase(); // Convert to lowercase for case-insensitive search
                String definition = record[1];

                // Add word and definition to the dictionary
                List<String> definitions = dictionary.getOrDefault(word, new ArrayList<>());
                definitions.add(definition);
                dictionary.put(word, definitions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param word to look up
     * @return a list of definitions, or an empty list if the word does not exist
     */
    public List<String> getDefinition(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }
}