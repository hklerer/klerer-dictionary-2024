package klerer.dictionary;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Reads the englishDictionary file ONCE. (put in constructor)
 */

public class EnglishDictionary {

    public EnglishDictionary() {
        // gets the file from the resources directory
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "englishDictionary.csv");

        CSVReader reader = new CSVReader(new InputStreamReader(in));
        String [] record = null;

        while ((record = reader.readNext()) != null) {
            // record is ONE line of the CSV
        }

        reader.close();
    }

    /**
     *
     * @param word to look up
     * @return a list of definitions, or an empty list if the word does not exist
     */
    public List<String> getDefinition(String word) {

    }
}
